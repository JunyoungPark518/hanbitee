package serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import domain.ArticleBean;
import service.BoardService;

public class BoardServiceImpl implements BoardService {
	private List<ArticleBean> list;
	Iterator<ArticleBean> it;
	
	public BoardServiceImpl() {
		list = new ArrayList<ArticleBean>();
		it = list.iterator();
	}

	@Override
	public void addArticle(ArticleBean param) {
		list.add(param);
	}

	@Override
	public ArticleBean findOne(ArticleBean param) {
		ArticleBean article = param;
		for(ArticleBean a : list) {
			if(param.getSeq().equals(a.getSeq())) {
				article = a;
				break;
			}
		}
		return article;
	}

	@Override
	public List<ArticleBean> findSome(ArticleBean param) {
		List<ArticleBean> listv = new ArrayList<ArticleBean>();
		for(ArticleBean a : list) {
			if(param.getId().equals(a.getId())) {
				listv.add(a);
			}
		}
		return listv;
	}

	@Override
	public List<ArticleBean> list() {
		return list;
	}

	@Override
	public void update(ArticleBean param) {
		Date d = new Date();
		for (ArticleBean a : list) {
			if(param.getSeq().equals(a.getSeq())) {
				param.setTitle(!param.getTitle().equals(a.getTitle()) ? param.getTitle() : a.getTitle());
				param.setContent(!param.getTitle().equals(a.getTitle()) ? param.getTitle() : a.getTitle());
				param.setId(a.getId());
				param.setRegdate(d.toString());
				list.set(list.indexOf(a), param);
			}
		}
	}

	@Override
	public void delete(ArticleBean param) {
		while(it.hasNext()) {
			if(it.next().getSeq().equals(param.getSeq()) && it.next()!=null) {
				it.remove();
			}
		}
	}
}
