package dao;

import domain.ArticleBean;

public interface ArticleDAO {
	public int insert(ArticleBean article) throws Exception;
	public ArticleBean selectBySeq(ArticleBean article) throws Exception;
	public int update(ArticleBean article) throws Exception;
	public int delete(ArticleBean article) throws Exception;
}
