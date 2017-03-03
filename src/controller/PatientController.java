package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.DoctorBean;
import domain.PatientBean;
import service.PatientService;
import serviceImpl.PatientServiceImpl;
import util.DispatcherServlet;
import util.ParamMap;
import util.Separator;
import util.SSNGenerator;

@WebServlet("/patient.do")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PatientService service;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PatientBean bean = new PatientBean();
		Separator.init(request, response);
		service = PatientServiceImpl.getInstance();
		switch (Separator.command.getAction()) {
		case "move":
			DispatcherServlet.send(request, response);
			break;
		case "mypage":
			String[] birth = service.getBirth(service.getSession());
			request.setAttribute("birth", birth[0]);
			request.setAttribute("age", birth[1]);
			request.setAttribute("gender", birth[2]);
			DispatcherServlet.send(request, response);
			break;
		case "login":
			bean.setPatID(request.getParameter("id"));
			bean.setPatPass(request.getParameter("pw"));
			try {
				PatientBean temp = service.login(bean);
				if(temp.getPatID().equals("FAIL") || !bean.getPatPass().equals(temp.getPatPass())) {
					Separator.command.setPage("loginForm");
					Separator.command.setView();
				} else {
//					DoctorBean doc = new DoctorServiceImpl().findById(null);
					session.setAttribute("user", temp);
//					session.setAttribute("userd", arg1);
				}
				DispatcherServlet.send(request, response);
			} catch (Exception e) {	}
			break;
		case "register":
//			String telecom = request.getParameter("telecom");
			bean.setPatName(request.getParameter("username"));
			bean.setPatID(request.getParameter("userid"));
			bean.setDocID(request.getParameter("doctor"));
			bean.setNurID(request.getParameter("nurse"));
			bean.setPatEmail(request.getParameter("email"));
			bean.setPatPass(request.getParameter("password"));
			bean.setPatAddr(request.getParameter("address"));
			bean.setPatJumin(SSNGenerator.getSsn(request.getParameter("birthy") + request.getParameter("birthm") + request.getParameter("birthd"), request.getParameter("rdBtn")));
			bean.setPatPhone(request.getParameter("phoneFirst") +"-"+ request.getParameter("phoneMid") +"-"+ request.getParameter("phoneLast"));
			bean.setPatGen(request.getParameter("rdBtn"));
			bean.setPatJob(ParamMap.getValues(request, "job"));
			try {
				if(service.join(bean)==0) {
					System.out.println("가입 실패");
					Separator.command.setPage("register");
					Separator.command.setView();
				}
				DispatcherServlet.send(request, response);
			} catch (Exception e) { }
			break;
		default:
			break;
		}
	}

}
