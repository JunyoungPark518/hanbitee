package daoImpl;
import java.sql.*;

import constants.Database;
import dao.MemberDAO;
import domain.MemberBean;
import enums.Vendor;
import factory.DatabaseFactory;
public class MemberDAOImpl implements MemberDAO {
	public static MemberDAOImpl getInstance() {	return new MemberDAOImpl(); } // Singleton Pattern, parameter가 없다(Overloading)
	
	@Override
	public int insert(MemberBean member) throws Exception {
		return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeUpdate(
				String.format("INSERT INTO Member(id, ssn, name, password, profileImg, phone, email, rank)"
						+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
						member.getId(), member.getSsn(), member.getName(), member.getPassword(),
						member.getProfileImg(), member.getPhone(), member.getEmail(), member.getRank())
				);
	}

	@Override
	public MemberBean selectById(MemberBean member) throws Exception {
		MemberBean temp = new MemberBean();
		ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
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
	public int update(MemberBean member) throws Exception {
		MemberBean temp = selectById(member);
		if(temp!=null) {
			return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeUpdate(
				String.format("UPDATE Member SET email='%s', password='%s', phone='%s', profileimg='%s' WHERE id='%s'", 
						!member.getEmail().equals(temp.getEmail()) && member.getEmail()!=null ? member.getEmail() : temp.getEmail(), 
						!member.getPassword().equals(temp.getPassword()) && member.getPassword()!=null ? member.getPassword() : temp.getPassword(), 
						!member.getPhone().equals(temp.getPhone()) && member.getPhone()!=null ? member.getPhone() : temp.getPhone(), 
						!member.getProfileImg().equals(temp.getProfileImg()) && member.getProfileImg()!=null ? member.getProfileImg() : temp.getProfileImg(), 
						member.getId())
				);
		}
		return 0;
	}

	@Override
	public int delete(MemberBean member) throws Exception {
		return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeUpdate(
				String.format("DELETE FROM Member WHERE id='%s'", member.getId()));
	}

}
