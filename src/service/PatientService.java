package service;

import domain.PatientBean;

public interface PatientService {
	/*
	 * CREATE: INSERT
	 */
	public int join(PatientBean member) throws Exception;
	/*
	 * READ: SELECT
	 */
	public PatientBean findById(PatientBean member) throws Exception;
	public PatientBean login(PatientBean member) throws Exception;
	public boolean logout(PatientBean member) throws Exception;
	/*
	 * UPDATE: UPDATE
	 */
	public int change(PatientBean member) throws Exception;
	/*
	 * DELETE: DELETE
	 */
	public int remove(PatientBean member) throws Exception;
}
