package daoImpl;

import java.sql.ResultSet;

import constants.Database;
import dao.DoctorDAO;
import domain.DoctorBean;
import domain.PatientBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class DoctorDAOImpl implements DoctorDAO {
	public static DoctorDAOImpl getInstance() { return new DoctorDAOImpl(); }
	final String prop = "doc_id, doc_pass, major_treat, doc_name, doc_gen, doc_phone, doc_email, doc_position";
	@Override
	public int insert(DoctorBean member) throws Exception {
		return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeUpdate(
				null
				);
	}

	@Override
	public DoctorBean selectById(DoctorBean member) throws Exception {
		DoctorBean temp = new DoctorBean();
		ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME, Database.PASSWORD).getConnection().createStatement().executeQuery(
				String.format("SELECT %s FROM Doctor WHERE doc_id='%s' OR doc_name='%s'",prop, member.getDocID(), member.getDocName()));
		if(rs.next()) {
			temp.setDocID(rs.getString("doc_id"));
			temp.setDocPass(rs.getString("doc_pass"));
			temp.setMajorTreat(rs.getString("major_treat"));
			temp.setDocName(rs.getString("doc_name"));
			temp.setDocGen(rs.getString("doc_gen"));
			temp.setDocPhone(rs.getString("doc_phone"));
			temp.setDocEmail(rs.getString("doc_email"));
			temp.setDocPosition(rs.getString("doc_position"));
		} else {
			temp.setDocID("FAIL");
		}
		return temp;
	}

	@Override
	public int update(DoctorBean member) throws Exception {
		return 0;
	}

	@Override
	public int delete(DoctorBean member) throws Exception {
		return 0;
	}

}
