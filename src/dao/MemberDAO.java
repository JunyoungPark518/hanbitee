package dao;

import domain.MemberBean;

// DAO에서는 쿼리문을 던져주는 것이기 떄문에 쿼리를 메서드명에 넣어주는것이 바람직함
public interface MemberDAO {
	/*
	 * CREATE: INSERT
	 */
	public void insert(MemberBean member);
	/*
	 * READ: SELECT
	 */
	public MemberBean selectById(String id);
	public boolean login(MemberBean member);
	/*
	 * UPDATE: UPDATE
	 */
	public void update(MemberBean member);
	/*
	 * DELETE: DELETE
	 */
	public void delete(MemberBean member);
}
