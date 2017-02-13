package dao;

import domain.MemberBean;

// DAO에서는 쿼리문을 던져주는 것이기 떄문에 쿼리를 메서드명에 넣어주는것이 바람직함
public interface MemberDAO {
	/*
	 * CREATE: INSERT
	 */
	public int insert(MemberBean member) throws Exception;
	/*
	 * READ: SELECT
	 */
	public MemberBean selectById(MemberBean member) throws Exception;
	public boolean login(MemberBean member) throws Exception;
	/*
	 * UPDATE: UPDATE
	 */
	public int update(MemberBean member) throws Exception;
	/*
	 * DELETE: DELETE
	 */
	public int delete(MemberBean member) throws Exception;
}
