package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import util.DispatcherServlet;
import util.Pagination;
import util.Separator;
import serviceImpl.BoardServiceImpl;
import domain.ArticleBean;
import handler.PageHandler;

@WebServlet("/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service.BoardService service = BoardServiceImpl.getInstance();
		Separator.init(request, response);
		ArticleBean bean = new ArticleBean();
		List<ArticleBean> list = new ArrayList<>();
		Map<String, String> params = new HashMap<>();
		PageHandler handler = new PageHandler();
		switch (Separator.command.getAction()) {
		case "move":
			break;
		case "list":
			params.put("pageNo", request.getParameter("pageNo"));
			params.put("count", String.valueOf(service.count()));
			handler.process(params);
			int[] pageArr = {handler.getAttr()[3], handler.getAttr()[4]};
			list = service.list(pageArr);
			String[] arr = {"count", "pageCount", "pageNo", "pageStart", "pageEnd", "blockStart", "blockEnd", "prevBlock", "nextBlock"};
			for(int i=0; i<9; i++) {
				request.setAttribute(arr[i], handler.getAttr()[i]);
			}
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
