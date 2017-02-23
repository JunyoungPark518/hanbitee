package serviceImpl;

import dao.DoctorDAO;
import daoImpl.DoctorDAOImpl;
import domain.DoctorBean;
import service.DoctorService;

public class DoctorServiceImpl implements DoctorService {
	private DoctorDAO dao;
	private DoctorBean serviceSession;
	
	private static DoctorServiceImpl instance = new DoctorServiceImpl();
	public static DoctorServiceImpl getInstance() { return instance; }
	
	public DoctorServiceImpl() {
		dao = DoctorDAOImpl.getInstance();
		serviceSession = new DoctorBean();
	}
	
	@Override
	public int join(DoctorBean member) throws Exception {
		return dao.insert(member);
	}
	
	@Override
	public DoctorBean findById(DoctorBean member) throws Exception {
		return dao.selectById(member);
	}
	
	@Override
	public DoctorBean login(DoctorBean member) throws Exception {
		serviceSession = findById(member);
		return findById(member);
	}
	
	@Override
	public int change(DoctorBean member) throws Exception {
		return dao.update(member);
	}
	
	@Override
	public int remove(DoctorBean member) throws Exception {
		return dao.delete(member);
	}

}
