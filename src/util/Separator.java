package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import factory.CommandFactory;

public class Separator {
	public static Command command;
	public static void init(HttpServletRequest request, HttpServletResponse response) { 
		String path = request.getServletPath();
		String directory = path.split("/")[1].split("\\.")[0];
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		String pageNo = request.getParameter("pageNo");
		System.out.println("Separator PATH:   " + path);
		System.out.println("Separator DIR:   " + directory);
		System.out.println("Separator ACTION:   " + action);
		System.out.println("Separator PAGE:   " + page);
		if(pageNo==null) {
			command = CommandFactory.createCommand(directory, action, page);
		} else {
			command = CommandFactory.createCommand(directory, action, page, pageNo);
		}
	}
}
