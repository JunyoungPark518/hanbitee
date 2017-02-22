package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DispatcherServlet;
import util.Separator;

@WebServlet("/home.do")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("------------- 서블릿 진입 성공 -------------");
		Separator.init(request, response);
		switch (Separator.command.getAction()) {
		case "move":
			DispatcherServlet.send(request, response);
			break;
		default:
			break;
		}
	}
}