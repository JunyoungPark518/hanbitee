package daoImpl;
import java.sql.*;

import constants.Database;
import dao.PatientDAO;
import domain.PatientBean;
import enums.Vendor;
import factory.DatabaseFactory;
public class PatientDAOImpl implements PatientDAO {
	public static PatientDAOImpl getInstance() { return new PatientDAOImpl(); } // Singleton Pattern, parameter가 없다(Overloading)
	final String prop = "p.pat_id, p.nur_id, p.doc_id, p.pat_pass, p.pat_name, p.pat_gen, p.pat_jumin, p.pat_addr, p.pat_phone, p.pat_email, p.pat_job, d.doc_name";
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
				String.format("SELECT %s FROM Patient p, Doctor d WHERE pat_id='%s' AND p.doc_id=d.doc_id",prop, member.getPatID()));
		if(rs.next()) {
			temp.setPatID(rs.getString("pat_id"));
			temp.setNurID(rs.getString("nur_id"));
			temp.setDocID(rs.getString("doc_name"));
			temp.setPatPass(rs.getString("pat_pass"));
			temp.setPatName(rs.getString("pat_name"));
			temp.setPatGen(rs.getString("pat_gen"));
			temp.setPatJumin(rs.getString("pat_jumin"));
			temp.setPatAddr(rs.getString("pat_addr"));
			temp.setPatPhone(rs.getString("pat_phone"));
			temp.setPatEmail(rs.getString("pat_email"));
			temp.setPatJob(rs.getString("pat_job"));
		} else {
			temp.setPatID("FAIL");
		}
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
