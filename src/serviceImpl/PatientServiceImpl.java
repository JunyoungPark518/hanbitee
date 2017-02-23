package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import dao.PatientDAO;
import daoImpl.PatientDAOImpl;
import domain.PatientBean;
import service.PatientService;

public class PatientServiceImpl implements PatientService {
	private PatientDAO dao;
	private PatientBean serviceSession;
	
	private static PatientServiceImpl instance = new PatientServiceImpl();
	public static PatientServiceImpl getInstance() { return instance; }
	
	public PatientServiceImpl() {
		dao = PatientDAOImpl.getInstance();
		serviceSession = new PatientBean();
	}
	
	@Override
	public PatientBean getSession() {
		return serviceSession;
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
		serviceSession = findById(member);
		return findById(member);
	}
	
	@Override
	public int change(PatientBean member) throws Exception {
		return dao.update(member);
	}

	@Override
	public int remove(PatientBean member) throws Exception {
		return dao.delete(member);		
	}

	@Override
	public String[] getBirth(PatientBean member) {
		String[] arr = new String[3];
		boolean flag = member.getPatJumin().charAt(7)=='3' || member.getPatJumin().charAt(7)=='4';
		arr[0] = flag ? "20" + member.getPatJumin().substring(0, 2) + "년 " + member.getPatJumin().substring(2, 4) + "월 " + member.getPatJumin().substring(4, 6) + "일" : "19" + member.getPatJumin().substring(0, 2) + "년 " + member.getPatJumin().substring(2, 4) + "월 " + member.getPatJumin().substring(4, 6) + "일";
		arr[1] = flag ? String.valueOf(Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())) - 2000 - Integer.parseInt(member.getPatJumin().substring(0,2))) + "세" : String.valueOf(Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date())) - 1900 - Integer.parseInt(member.getPatJumin().substring(0,2))) + "세";
		arr[2] = member.getPatGen().equals("M") ? "남자" : "여자";
		return arr;
	}
}
