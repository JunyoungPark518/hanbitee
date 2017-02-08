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
		String[][] arr1 = {
				{"1","James","Hello","2016-2-6 17:30"},
				{"2","Tom","Hi","2016-8-6 17:30"},
				{"3","Alex","Good Morning","2016-11-20 17:30"},
				{"4","Betty","I'm happy","2016-12-25 17:30"},
				{"5","John","Thank you","2017-2-6 17:30"}
			};
		
		for(int i=0; i<arr1.length; i++) {
			ArticleBean a = new ArticleBean();
			a.setSeq(arr1[i][0]);
			a.setId(arr1[i][1]);
			a.setTitle(arr1[i][2]);
			a.setRegdate(arr1[i][3]);
			list.add(a);
		}
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
