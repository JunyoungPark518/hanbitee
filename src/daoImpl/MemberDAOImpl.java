package daoImpl;
import java.sql.*;

import constants.Database;
import dao.MemberDAO;
import domain.MemberBean;
import enums.Vender;
import factory.DatabaseFactory;
public class MemberDAOImpl implements MemberDAO {
	Connection conn;
	Statement stmt;
	ResultSet set;
	String sql;
	
	public MemberDAOImpl() {
		try {
			conn = DatabaseFactory.createDatabase(Vender.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection();
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insert(MemberBean member) {
		sql = String.format("INSERT INTO Member(id, ssn, name, password, profileImg, phone, email, rank)"
				+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
				member.getId(), member.getSsn(), member.getName(), member.getPassword(),
				member.getProfileImg(), member.getPhone(), member.getEmail(), member.getRank());
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member = new MemberBean();
		sql = String.format("SELECT * FROM Member WHERE id='%s'", id);
		try {
			set = stmt.executeQuery(sql);
			while(set.next()) {
				member.setId(set.getString("id"));
				member.setSsn(set.getString("ssn"));
				member.setName(set.getString("name"));
				member.setPassword(set.getString("password"));
				member.setProfileImg(set.getString("profileImg"));
				member.setPhone(set.getString("phone"));
				member.setEmail(set.getString("email"));
				member.setRank(set.getString("rank"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public boolean login(MemberBean member) {
		boolean bool = false;
		sql = String.format("SELECT id, password FROM Member WHERE id='%s'", member.getId());
		try {
			set = stmt.executeQuery(sql);
			while(set.next()) {
				if(member.getId().equals(set.getString("id")) && member.getPassword().equals(set.getString("password"))) {
					bool = true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public void update(MemberBean member) {
		String instance = "", value = "";
		MemberBean cmp = selectById(member.getId());
		if(cmp!=null) {
			if(!member.getPassword().equals(cmp.getPassword()) && member.getPassword()!=null) {
				instance = "password"; 
				value = member.getPassword();
			} else if(!member.getEmail().equals(cmp.getEmail()) && member.getEmail()!=null) {
				instance = "email";
				value = member.getEmail();
			} else if(!member.getPhone().equals(cmp.getPhone()) && member.getPhone()!=null) {
				instance = "phone";
				value = member.getPhone();
			} else if(!member.getProfileImg().equals(cmp.getProfileImg()) && member.getProfileImg()!=null) {
				instance = "profileImg";
				value = member.getProfileImg();
			} else if(!member.getRank().equals(cmp.getRank()) && member.getRank()!=null) {
				instance = "rank";
				value = member.getRank();
			}
			
			sql = String.format("UPDATE Member SET %s='%s' WHERE id='%s'", 
					instance, value, member.getId());
		}
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(MemberBean member) {
		sql = String.format("DELETE FROM Member WHERE id='%s'", member.getId());
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
