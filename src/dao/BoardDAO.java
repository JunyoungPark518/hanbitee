package dao;
import java.util.*;
import domain.ArticleBean;

public interface BoardDAO {
	public int insert(ArticleBean article) throws Exception;
	public ArticleBean selectBySeq(ArticleBean article) throws Exception;
	public List<ArticleBean> selectByWord(ArticleBean article) throws Exception;
	public List<ArticleBean> selectAll() throws Exception;
	public int update(ArticleBean article) throws Exception;
	public int delete(ArticleBean article) throws Exception;
	public int count() throws Exception;
}
