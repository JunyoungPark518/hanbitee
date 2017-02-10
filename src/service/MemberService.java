package service;

import domain.MemberBean;

public interface MemberService {
	/*
	 * CREATE: INSERT
	 */
	public void join(MemberBean member) throws Exception;
	/*
	 * READ: SELECT
	 */
	public MemberBean findById(MemberBean member) throws Exception;
	public boolean login(MemberBean member) throws Exception;
	/*
	 * UPDATE: UPDATE
	 */
	public void change(MemberBean member) throws Exception;
	/*
	 * DELETE: DELETE
	 */
	public void remove(MemberBean member) throws Exception;
}
