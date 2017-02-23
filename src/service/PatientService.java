package service;

import domain.PatientBean;

public interface PatientService {
	public int join(PatientBean member) throws Exception;
	public PatientBean findById(PatientBean member) throws Exception;
	public PatientBean login(PatientBean member) throws Exception;
	public int change(PatientBean member) throws Exception;
	public int remove(PatientBean member) throws Exception;
	// 추가된 로직
	public String[] getBirth(PatientBean member);
	public PatientBean getSession();
}
