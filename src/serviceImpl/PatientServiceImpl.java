package serviceImpl;

import dao.PatientDAO;
import daoImpl.PatientDAOImpl;
import domain.PatientBean;
import service.PatientService;

public class PatientServiceImpl implements PatientService {
	private PatientDAO dao;
	private static PatientServiceImpl instance = new PatientServiceImpl();
	public static PatientServiceImpl getInstance() { return instance; }
	
	public PatientServiceImpl() {
		dao = PatientDAOImpl.getInstance();
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
	public PatientBean login(PatientBean member) throws Exception {
		return findById(member);
	}

	@Override
	public boolean logout(PatientBean member) throws Exception {
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
