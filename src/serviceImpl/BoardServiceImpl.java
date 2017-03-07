package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import dao.BoardDAO;
import daoImpl.BoardDAOImpl;
import domain.ArticleBean;
import service.BoardService;

public class BoardServiceImpl implements BoardService {
	private BoardDAO dao;
	private static BoardServiceImpl instance = new BoardServiceImpl();
	public static BoardServiceImpl getInstance() { return instance; }
	private List<ArticleBean> list;
	Iterator<ArticleBean> it;
	
	public BoardServiceImpl() {
		list = new ArrayList<ArticleBean>();
		it = list.iterator();
		dao = BoardDAOImpl.getInstance();
	}

	@Override
	public int addArticle(ArticleBean param) throws Exception{
		return dao.insert(param);
	}

	@Override
	public ArticleBean findOne(ArticleBean param) throws Exception {
		return BoardDAOImpl.getInstance().selectBySeq(param);
	}

	@Override
	public List<ArticleBean> findSome(ArticleBean param) throws Exception {
		return BoardDAOImpl.getInstance().selectByWord(param);
	}

	@Override
	public List<ArticleBean> list(int[] pageArr) {
		return BoardDAOImpl.getInstance().selectAll(pageArr);
	}

	@Override
	public int update(ArticleBean param) throws Exception {
		for (ArticleBean a : list) {
			if(param.getSeq().equals(a.getSeq())) {
				if(param.getTitle()==null) {
					param.setTitle("제목을 입력하세요");
				}
				param.setTitle(!param.getTitle().equals(a.getTitle()) ? param.getTitle() : a.getTitle());
				
				if(param.getContent()==null){
					param.setContent("내용을 입력하세요");
				}
				param.setContent(!param.getContent().equals(a.getContent()) ? param.getContent() : a.getContent());
				param.setId(a.getId());
				param.setRegdate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()).toString());
				list.set(list.indexOf(a), param);
			}
		}
		return dao.update(param);
	}

	@Override
	public int delete(ArticleBean param) throws Exception {
		return dao.delete(param);
	}

	@Override
	public int count() {
		return dao.count();
	}
}
