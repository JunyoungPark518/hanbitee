package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PatientBean;
import service.PatientService;
import serviceImpl.PatientServiceImpl;
import util.DispatcherServlet;
import util.Separator;

@WebServlet("/patient.do")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PatientService service;
	
	public PatientController() {
		service = new PatientServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("------------- 서블릿 진입 성공 -------------");
		Separator.init(request, response);
		service = PatientServiceImpl.getInstance();
		switch (Separator.command.getAction()) {
		case "move":
			DispatcherServlet.send(request, response);
			break;
		case "login":
			PatientBean bean = new PatientBean();
			bean.setPatID(request.getParameter("id"));
			bean.setPatPass(request.getParameter("pw"));
			try {
				PatientBean temp = service.login(bean);
				if(temp.getPatID().equals("FAIL") || !bean.getPatPass().equals(temp.getPatPass())) {
					Separator.command.setPage("loginForm");
					Separator.command.setView();
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
