package daoImpl;
import java.sql.*;

import constants.Database;
import dao.PatientDAO;
import domain.PatientBean;
import enums.Vendor;
import factory.DatabaseFactory;
public class PatientDAOImpl implements PatientDAO {
	public static PatientDAOImpl getInstance() {	return new PatientDAOImpl(); } // Singleton Pattern, parameter가 없다(Overloading)
	
	@Override
	public int insert(PatientBean member) throws Exception {
		return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeUpdate(
				null
				);
	}

	@Override
	public PatientBean selectById(PatientBean member) throws Exception {
		PatientBean temp = new PatientBean();
		ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
				String.format(null));
//		if(rs.next() && rs.getString("password").equals(member.getPassword())) {
//			temp.setId(rs.getString("id"));
//			temp.setSsn(rs.getString("ssn"));
//			temp.setName(rs.getString("name"));
//			temp.setPassword(rs.getString("password"));
//			temp.setProfileImg(rs.getString("profileImg"));
//			temp.setPhone(rs.getString("phone"));
//			temp.setEmail(rs.getString("email"));
//			temp.setRank(rs.getString("rank"));
//		} else {
//			temp.setId(member.getId());
//			temp.setPassword(rs.getString("password"));
//		}
		return temp;
	}

	@Override
	public int update(PatientBean member) throws Exception {
		PatientBean temp = selectById(member);
		if(temp!=null) {
			return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeUpdate(
				String.format(null)
//						!member.getEmail().equals(temp.getEmail()) && member.getEmail()!=null ? member.getEmail() : temp.getEmail(), 
//						!member.getPassword().equals(temp.getPassword()) && member.getPassword()!=null ? member.getPassword() : temp.getPassword(), 
//						!member.getPhone().equals(temp.getPhone()) && member.getPhone()!=null ? member.getPhone() : temp.getPhone(), 
//						!member.getProfileImg().equals(temp.getProfileImg()) && member.getProfileImg()!=null ? member.getProfileImg() : temp.getProfileImg(), 
//						member.getId())
				);
		}
		return 0;
	}

	@Override
	public int delete(PatientBean member) throws Exception {
		return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeUpdate(
				String.format(null));
	}

}
