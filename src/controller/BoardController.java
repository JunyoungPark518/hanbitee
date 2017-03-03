package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import util.DispatcherServlet;
import util.Separator;
import serviceImpl.BoardServiceImpl;
import domain.ArticleBean;

@WebServlet("/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service.BoardService service = BoardServiceImpl.getInstance();
		Separator.init(request, response);
		HttpSession session = request.getSession();
		ArticleBean bean = new ArticleBean();
		List<ArticleBean> list = new ArrayList<>();
		switch (Separator.command.getAction()) {
		case "move":
			break;
		case "list":
			try {
				list = service.list();
				int rowCount = 5;
			} catch (Exception e) {	}
//			int card = list.size();
//			int rowCount = 5;
//			int pageCount = (card%rowCount==0) ? card/rowCount : card/rowCount+1;
			request.setAttribute("count", list.size());
			request.setAttribute("list", list);
			break;
		case "detail":
			bean.setSeq(request.getParameter("seq"));
			try {
				bean = service.findOne(bean);
			} catch (Exception e) {	}
			request.setAttribute("art", bean);
			break;
		case "change":
			bean.setSeq(request.getParameter("seq"));
			bean.setContent(request.getParameter("content"));
			bean.setRegdate(null);
			bean.setTitle(request.getParameter("title"));
			try {
				if(service.update(bean)==0) {
					
				}
			} catch (Exception e) {}
			break;
		}
		DispatcherServlet.send(request, response);
	}

}
