package dao;

import domain.DoctorBean;

public interface DoctorDAO {
	public int insert(DoctorBean member) throws Exception;
	public DoctorBean selectById(DoctorBean member) throws Exception;
	public int update(DoctorBean member) throws Exception;
	public int delete(DoctorBean member) throws Exception;
}
