package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		ArticleBean bean = new ArticleBean();
		List<ArticleBean> list = new ArrayList<>();
		switch (Separator.command.getAction()) {
		case "move":
			break;
		case "list":
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
			int count = 0, rowCount = 5, blockSize = 5;
			int pageStart = (pageNo-1)*rowCount+1;
			int pageEnd = pageNo*rowCount;
			int[] pageArr = {pageStart,pageEnd};
			try {
				list = service.list(pageArr);
				count = service.count();
			} catch (Exception e1) {}
			int pageCount = (count%rowCount==0) ? count/rowCount : count/rowCount + 1;
			int blockStart = pageNo-((pageNo-1)%blockSize);
			int prevBlock = blockStart - blockSize;
			int nextBlock = blockStart + blockSize;
			int blockEnd = (blockStart+rowCount-1 < pageCount) ? blockStart+blockSize-1 : pageCount;
			request.setAttribute("count", count);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("list", list);
			request.setAttribute("pageStart", pageStart);
			request.setAttribute("pageEnd", pageEnd);
			request.setAttribute("blockStart", blockStart);
			request.setAttribute("blockEnd", blockEnd);
			request.setAttribute("prevBlock", prevBlock);
			request.setAttribute("nextBlock", nextBlock);
			request.setAttribute("pageNo", pageNo);
			System.out.println("blockEnd"+blockEnd);
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
