package daoImpl;

import java.sql.ResultSet;
import java.util.*;

import constants.Database;
import dao.BoardDAO;
import domain.ArticleBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class BoardDAOImpl implements BoardDAO {
	public static BoardDAOImpl getInstance() { return new BoardDAOImpl(); }
	
	@Override
	public int insert(ArticleBean article) throws Exception {
		return  DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeUpdate(
				String.format(
						"INSERT INTO Article(art_seq, id, title, content, regdate, read_count) "
						+ "VALUES (art_seq, '%s','%s','%s','%s','%s')", 
						article.getId(), article.getTitle(), article.getContent(), article.getRegdate(), article.getReadCount()
				));
	}

	@Override
	public ArticleBean selectBySeq(ArticleBean article) throws Exception {
		ArticleBean temp = new ArticleBean();
		ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
				String.format("SELECT * FROM Article WHERE art_seq='%d'", Integer.parseInt(article.getSeq())));
		if(rs.next()) {
			temp.setSeq(rs.getString("art_seq"));
			temp.setId(rs.getString("id"));
			temp.setTitle(rs.getString("title"));
			temp.setContent(rs.getString("content"));
			temp.setRegdate(rs.getString("regdate"));
			temp.setReadCount(rs.getString("read_count"));
		}
		return temp;
	}

	@Override
	public List<ArticleBean> selectByWord(ArticleBean article) throws Exception {
		List<ArticleBean> list = new ArrayList<ArticleBean>();
		ResultSet rs = null;
		if(article.getId()!=null) {
			rs = DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
					String.format("SELECT * FROM Article WHERE id like '%s'", 
							"%" + article.getId() + "%"));
		} else if(article.getTitle()!=null) {
			rs = DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
					String.format("SELECT * FROM Article WHERE title like '%s'", 
							"%" + article.getTitle() + "%"));
		} else if(article.getContent()!=null) {
			rs = DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
					String.format("SELECT * FROM Article WHERE content like '%s'", 
							"%" + article.getContent() + "%"));
		} else if(article.getRegdate()!=null) {
			rs = DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
					String.format("SELECT * FROM Article WHERE regdate like '%s'", 
							"%" + article.getRegdate() + "%" )
					);
		}
		while(rs.next()) {
			ArticleBean temp = new ArticleBean();
			temp.setSeq(rs.getString("art_seq"));
			temp.setId(rs.getString("id"));
			temp.setTitle(rs.getString("title"));
			temp.setContent(rs.getString("content"));
			temp.setRegdate(rs.getString("regdate"));
			temp.setReadCount(rs.getString("read_count"));
			list.add(temp);
		}
		return list;
	}
	
	@Override
	public List<ArticleBean> selectAll() throws Exception {
		List<ArticleBean> list = new ArrayList<ArticleBean>();
		ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery("SELECT * FROM Article");
		while(rs.next()) {
				ArticleBean temp = new ArticleBean();
				temp.setSeq(rs.getString("art_seq"));
				temp.setId(rs.getString("id"));
				temp.setTitle(rs.getString("title"));
				temp.setContent(rs.getString("content"));
				temp.setRegdate(rs.getString("regdate"));
				temp.setReadCount(rs.getString("read_count"));
				list.add(temp);
		}
		return list;
	}
	
	@Override
	public int update(ArticleBean article) throws Exception {
		ArticleBean temp = selectBySeq(article);
		if(temp!=null) {
			return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeUpdate(
					String.format("UPDATE Article SET title='%s', content='%s', regdate='%s' WHERE art_seq=%d", 
							!article.getTitle().equals(temp.getTitle()) && article.getTitle()!=null ? article.getTitle() : temp.getTitle(), 
							!article.getContent().equals(temp.getContent()) && article.getContent()!=null ? article.getContent() : temp.getContent(), 
							!article.getRegdate().equals(temp.getRegdate()) && article.getRegdate()!=null ? article.getRegdate() : temp.getRegdate(), 
							article.getSeq())
					);
		}
		return 0;
	}

	@Override
	public int delete(ArticleBean article) throws Exception {
		return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeUpdate(
				String.format("DELETE FROM Article WHERE art_seq=%d", article.getSeq()));
	}


}
