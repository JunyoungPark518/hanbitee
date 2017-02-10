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
	public MemberBean selectById(MemberBean member) throws Exception {
		MemberBean temp = new MemberBean();
		ResultSet rs = DatabaseFactory.createDatabase(Vender.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
				String.format("SELECT * FROM Member WHERE id='%s'", member.getId()));
		if(rs.next() && rs.getString("password").equals(member.getPassword())) {
			temp.setId(rs.getString("id"));
			temp.setSsn(rs.getString("ssn"));
			temp.setName(rs.getString("name"));
			temp.setPassword(rs.getString("password"));
			temp.setProfileImg(rs.getString("profileImg"));
			temp.setPhone(rs.getString("phone"));
			temp.setEmail(rs.getString("email"));
			temp.setRank(rs.getString("rank"));
		} else {
			temp.setId(member.getId());
			temp.setPassword(rs.getString("password"));
		}
		return temp;
	}

	@Override
	public boolean login(MemberBean member) throws Exception {
		MemberBean temp = selectById(member);
		if(temp.getPassword().equals(member.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public void update(MemberBean member) throws Exception {
		MemberBean temp = selectById(member);
		if(temp!=null) {
			DatabaseFactory.createDatabase(Vender.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
				String.format("UPDATE Member SET email='%s', name='%s', password='%s', phone='%s', profileimg='%s' WHERE id='%s'", 
						!member.getEmail().equals(temp.getEmail()) && !member.getEmail().equals(null) ? member.getEmail() : temp.getEmail(), 
						!member.getName().equals(temp.getName()) && !member.getName().equals(null) ? member.getName() : temp.getName(), 
						!member.getName().equals(temp.getName()) && !member.getName().equals(null) ? member.getPassword() : temp.getPassword(), 
						!member.getPhone().equals(temp.getPhone()) && !member.getPhone().equals(null) ? member.getPhone() : temp.getPhone(), 
						!member.getProfileImg().equals(temp.getProfileImg()) && !member.getProfileImg().equals(null) ? member.getProfileImg() : temp.getProfileImg(), 
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
