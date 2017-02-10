package dao;

import domain.MemberBean;

// DAO에서는 쿼리문을 던져주는 것이기 떄문에 쿼리를 메서드명에 넣어주는것이 바람직함
public interface MemberDAO {
	/*
	 * CREATE: INSERT
	 */
	public void insert(MemberBean member) throws Exception;
	/*
	 * READ: SELECT
	 */
	public MemberBean selectById(String id) throws Exception;
	public boolean login(MemberBean member) throws Exception;
	/*
	 * UPDATE: UPDATE
	 */
	public void update(MemberBean member) throws Exception;
	/*
	 * DELETE: DELETE
	 */
	public void delete(MemberBean member) throws Exception;
}
