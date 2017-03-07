package service;

import java.util.List;

import domain.ArticleBean;

public interface BoardService {
	// CREATE
	public int addArticle(ArticleBean param) throws Exception;
	// READ: SELECT
	public ArticleBean findOne(ArticleBean param) throws Exception;
	public List<ArticleBean> findSome(ArticleBean param) throws Exception;
	public List<ArticleBean> list(int[] pageArr);
	public int count();
	// UPDATE
	public int update(ArticleBean param) throws Exception;
	// DELETE
	public int delete(ArticleBean param) throws Exception;
}
