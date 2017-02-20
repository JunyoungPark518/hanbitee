package dao;

import domain.PatientBean;

// DAO에서는 쿼리문을 던져주는 것이기 떄문에 쿼리를 메서드명에 넣어주는것이 바람직함
public interface PatientDAO {
	public int insert(PatientBean member) throws Exception;
	public PatientBean selectById(PatientBean member) throws Exception;
	public int update(PatientBean member) throws Exception;
	public int delete(PatientBean member) throws Exception;
}
