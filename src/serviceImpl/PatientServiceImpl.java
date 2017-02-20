package serviceImpl;

import dao.PatientDAO;
import daoImpl.PatientDAOImpl;
import domain.PatientBean;
import service.PatientService;

public class PatientServiceImpl implements PatientService {
	private PatientDAO dao;
	private static PatientServiceImpl instance = new PatientServiceImpl();
	public static PatientServiceImpl getInstance() {	return instance; }
	private static PatientBean session;
	public static PatientBean getSession() { return session; }
	
	public PatientServiceImpl() {
		dao = PatientDAOImpl.getInstance();
		session = new PatientBean();
	}
	
	@Override
	public int join(PatientBean member) throws Exception {
		return dao.insert(member);
	}

	@Override
	public PatientBean findById(PatientBean member) throws Exception {
		return dao.selectById(member);
	}

	@Override
	public boolean login(PatientBean member) throws Exception {
		PatientBean temp = findById(member);
//		if(member.getPassword().equals(temp.getPassword())) {
//			session = temp;
//			return true;
//		}
		return false;
	}

	@Override
	public boolean logout(PatientBean member) throws Exception {
		session = null;
		return true;
	}
	
	@Override
	public int change(PatientBean member) throws Exception {
		return dao.update(member);
	}

	@Override
	public int remove(PatientBean member) throws Exception {
		return dao.delete(member);		
	}

	
}
