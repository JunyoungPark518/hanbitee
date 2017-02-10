package daoImpl;
import java.sql.*;

import constants.Database;
import dao.MemberDAO;
import domain.MemberBean;
import enums.Vender;
import factory.DatabaseFactory;
public class MemberDAOImpl implements MemberDAO {
	public static MemberDAOImpl getInstance() {	return new MemberDAOImpl(); } // Singleton Pattern

	@Override
	public void insert(MemberBean member) throws Exception {
		DatabaseFactory.createDatabase(Vender.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
				String.format("INSERT INTO Member(id, ssn, name, password, profileImg, phone, email, rank)"
						+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
						member.getId(), member.getSsn(), member.getName(), member.getPassword(),
						member.getProfileImg(), member.getPhone(), member.getEmail(), member.getRank())
				);
	}

	@Override
	public MemberBean selectById(String id) throws Exception {
		MemberBean member = new MemberBean();
		ResultSet rs = DatabaseFactory.createDatabase(Vender.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
				String.format("SELECT * FROM Member WHERE id='%s'", id));
		if(rs.next()) {
			member.setId(rs.getString("id"));
			member.setSsn(rs.getString("ssn"));
			member.setName(rs.getString("name"));
			member.setPassword(rs.getString("password"));
			member.setProfileImg(rs.getString("profileImg"));
			member.setPhone(rs.getString("phone"));
			member.setEmail(rs.getString("email"));
			member.setRank(rs.getString("rank"));
		}
		return member;
	}

	@Override
	public boolean login(MemberBean member) throws Exception {
		boolean bool = false;
		if(member.getPassword().equals(DatabaseFactory.createDatabase(Vender.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
						String.format("SELECT password FROM Member WHERE id='%s' and password='%s'", member.getId(), member.getPassword())
						).getObject("password"))) {
			bool = true;
		}
		return bool;
	}

	@Override
	public void update(MemberBean member) throws Exception {
		MemberBean cmp = selectById(member.getId());
		if(cmp!=null) {
			DatabaseFactory.createDatabase(Vender.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
				String.format("UPDATE Member SET email='%s', name='%s', password='%s', phone='%s', profileimg='%s' WHERE id='%s'", 
						!member.getEmail().equals(cmp.getEmail()) && !member.getEmail().equals(null) ? member.getEmail() : cmp.getEmail(), 
						!member.getName().equals(cmp.getName()) && !member.getName().equals(null) ? member.getName() : cmp.getName(), 
						!member.getName().equals(cmp.getName()) && !member.getName().equals(null) ? member.getPassword() : cmp.getPassword(), 
						!member.getPhone().equals(cmp.getPhone()) && !member.getPhone().equals(null) ? member.getPhone() : cmp.getPhone(), 
						!member.getProfileImg().equals(cmp.getProfileImg()) && !member.getProfileImg().equals(null) ? member.getProfileImg() : cmp.getProfileImg(), 
						member.getId())
				);
		}
	}

	@Override
	public void delete(MemberBean member) throws Exception {
		DatabaseFactory.createDatabase(Vender.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
				String.format("DELETE FROM Member WHERE id='%s'", member.getId()));
	}

}
