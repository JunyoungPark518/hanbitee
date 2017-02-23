package service;

import domain.DoctorBean;

public interface DoctorService {
	public int join(DoctorBean member) throws Exception;
	public DoctorBean findById(DoctorBean member) throws Exception;
	public DoctorBean login(DoctorBean member) throws Exception;
	public int change(DoctorBean member) throws Exception;
	public int remove(DoctorBean member) throws Exception;
}
