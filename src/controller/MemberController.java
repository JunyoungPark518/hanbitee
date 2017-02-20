package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/patient/loginForm.do","/patient/registerForm.do","/admin/loginForm.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------- 서블릿 진입 성공 -------------");
	}
	
	protected void doPatient(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String patPath = "/WEB-INF/jsp/patient/", extension = ".jsp";
		String cmd = "";
		switch (path) {
		case "/patient/login.do":
			request.getRequestDispatcher(patPath + "loginForm" + extension).forward(request, response);
			break;
		case "/admin/login.do":
			request.getRequestDispatcher(patPath + "loginForm" + extension).forward(request, response);
			break;
		case "/patient/register.do":
			request.getRequestDispatcher(patPath + "registerForm" + extension).forward(request, response);
			break;
		default:
			break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
