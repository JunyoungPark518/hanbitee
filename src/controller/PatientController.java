package controller;

import java.io.IOException;
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
import util.Separator;

@WebServlet("/patient.do")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PatientService service;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
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
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
