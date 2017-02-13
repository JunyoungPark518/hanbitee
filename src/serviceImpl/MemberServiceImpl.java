package serviceImpl;

import daoImpl.MemberDAOImpl;
import domain.MemberBean;
import service.MemberService;

public class MemberServiceImpl implements MemberService {
	private static MemberServiceImpl instance = new MemberServiceImpl();
	public static MemberServiceImpl getInstance() {	return instance; }
	private MemberBean session; 
	public MemberServiceImpl() {
		session = new MemberBean();
	}

	@Override
	public int join(MemberBean member) throws Exception {
		return MemberDAOImpl.getInstance().insert(member);
	}

	@Override
	public MemberBean findById(MemberBean member) throws Exception {
		session = MemberDAOImpl.getInstance().selectById(member);
		return session;
	}

	@Override
	public boolean login(MemberBean member) throws Exception {
		return MemberDAOImpl.getInstance().login(session);
	}

	@Override
	public int change(MemberBean member) throws Exception {
		return MemberDAOImpl.getInstance().update(member);
	}

	@Override
	public int remove(MemberBean member) throws Exception {
		return MemberDAOImpl.getInstance().delete(member);		
	}
	
}
