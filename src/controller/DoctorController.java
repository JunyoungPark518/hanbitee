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
import service.DoctorService;
import service.PatientService;
import serviceImpl.DoctorServiceImpl;
import serviceImpl.PatientServiceImpl;
import util.DispatcherServlet;
import util.Separator;

@WebServlet("/doctor.do")
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DoctorService service;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		service = DoctorServiceImpl.getInstance();
		Separator.init(request, response);
		switch (Separator.command.getAction()) {
		case "move":
			DoctorBean temp = new DoctorBean();
			temp.setDocName(request.getParameter("doc"));
			System.out.println("무브로 들어온 의사이름: " + temp.getDocName());
			try {
				temp = service.findById(temp);
				System.out.println("서비스 진입 후 나와야 하는 템프값: " + temp);
				session.setAttribute("doctor", temp);
			} catch (Exception e) {	}
			DispatcherServlet.send(request, response);
			break;
		case "mypage":
			DispatcherServlet.send(request, response);
			break;
		case "login":
			DispatcherServlet.send(request, response);
			break;
		default:
			break;
		}
	}

}
