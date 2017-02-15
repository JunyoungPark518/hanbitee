package service;

import domain.MemberBean;

public interface MemberService {
	/*
	 * CREATE: INSERT
	 */
	public int join(MemberBean member) throws Exception;
	/*
	 * READ: SELECT
	 */
	public MemberBean findById(MemberBean member) throws Exception;
	public boolean login(MemberBean member) throws Exception;
	public boolean logout(MemberBean member) throws Exception;
	/*
	 * UPDATE: UPDATE
	 */
	public int change(MemberBean member) throws Exception;
	/*
	 * DELETE: DELETE
	 */
	public int remove(MemberBean member) throws Exception;
}
