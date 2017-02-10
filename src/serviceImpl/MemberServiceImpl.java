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
	public void join(MemberBean member) throws Exception {
		MemberDAOImpl.getInstance().insert(member);
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
	public void change(MemberBean member) throws Exception {
		MemberDAOImpl.getInstance().update(member);
	}

	@Override
	public void remove(MemberBean member) throws Exception {
		MemberDAOImpl.getInstance().delete(member);		
	}
	
	public String calcGender(String ssn) {
		String gender = "";
		char ch = ssn.charAt(7);
		if(ch=='1'||ch=='3') {
			gender = "남자";
		} else if(ch=='2'||ch=='4') {
			gender = "여자";
		} else if(ch=='5'||ch=='6') {
			gender = "외국인";
		} else {
			gender = "알 수 없음";
		}
		return gender;
	}
}
