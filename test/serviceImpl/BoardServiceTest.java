package serviceImpl;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Ignore;
import org.junit.Test;

import domain.ArticleBean;

public class BoardServiceTest {
	BoardServiceImpl service = BoardServiceImpl.getInstance();

	@Test @Ignore
	public void testAddArticle() throws Exception {
		ArticleBean bean = new ArticleBean();
		bean.setSeq("30");
		bean.setId("babungv");
		bean.setReadCount("30");
		bean.setRegdate("2017-02-16");
		bean.setTitle("안녕하세요");
		bean.setContent("반갑습니다 박준용입니다.");
		assertTrue(service.addArticle(bean)==1);
	}

	@Test @Ignore
	public void testFindOne() throws Exception {
		ArticleBean bean = new ArticleBean();
		bean.setSeq("1");
		assertTrue(service.findOne(bean).getId().equals("babungv"));
	}

	@Test @Ignore
	public void testFindSome() throws Exception {
		ArticleBean param = new ArticleBean();
		param.setId("babungv");
		List<ArticleBean> list = service.findSome(param);
		assertTrue(!list.equals(null));
	}

	@Test @Ignore
	public void testList() throws Exception {
		List<ArticleBean> list = service.list();
		assertTrue(!list.equals(null));
	}

	@Test 
	public void testUpdate() throws Exception {
		ArticleBean bean = new ArticleBean();
		bean.setSeq("1");
		bean.setTitle("게시글 제목 수정");
		bean.setContent("123");
		assertTrue(service.update(bean)==1);
	}

	@Test @Ignore
	public void testDelete() throws Exception {
		ArticleBean bean = new ArticleBean();
		bean.setSeq("21");
		assertTrue(service.delete(bean)==1);
	}

}
