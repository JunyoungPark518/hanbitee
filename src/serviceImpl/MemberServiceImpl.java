package serviceImpl;

import dao.MemberDAO;
import daoImpl.MemberDAOImpl;
import domain.MemberBean;
import service.MemberService;

public class MemberServiceImpl implements MemberService {
	private MemberDAO dao;
	private static MemberServiceImpl instance = new MemberServiceImpl();
	public static MemberServiceImpl getInstance() {	return instance; }
	private MemberBean session;
	public MemberBean getSession() { return session; }
	
	public MemberServiceImpl() {
		dao = MemberDAOImpl.getInstance();
		session = new MemberBean();
	}
	
	@Override
	public int join(MemberBean member) throws Exception {
		return dao.insert(member);
	}

	@Override
	public MemberBean findById(MemberBean member) throws Exception {
		return dao.selectById(member);
	}

	@Override
	public boolean login(MemberBean member) throws Exception {
		MemberBean temp = findById(member);
		if(member.getPassword().equals(temp.getPassword())) {
			session = temp;
			return true;
		}
		return false;
	}

	@Override
	public boolean logout(MemberBean member) throws Exception {
		session = null;
		return true;
	}
	
	@Override
	public int change(MemberBean member) throws Exception {
		return dao.update(member);
	}

	@Override
	public int remove(MemberBean member) throws Exception {
		return dao.delete(member);		
	}

	
}
