package util;

import javax.swing.JOptionPane;

import dao.MemberDAO;
import daoImpl.MemberDAOImpl;
import domain.MemberBean;
import service.MemberService;
import serviceImpl.MemberServiceImpl;

public class DAOTest {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null;
		String[] temp = null;
		try {
			while(true) {
				switch (input("1.가입/2.조회/3.수정/4.삭제/5.로그인/0.종료")) {
				case "1":
					member = new MemberBean();
					temp = input("id/ssn/name/password/phone/email/profimg").split("/");
					member.setId(temp[0]);
					member.setSsn(temp[1]);
					member.setName(temp[2]);
					member.setPassword(temp[3]);
					member.setPhone(temp[4]);
					member.setEmail(temp[5]);
					member.setProfileImg(temp[6]);
					member.setRank("C");
					service.join(member);
					break;
				case "2":
					member = new MemberBean();
					member = service.findById(input("id입력"));
					JOptionPane.showMessageDialog(null, member.toString());
					break;
				case "3":
					member = new MemberBean();
					member.setId(input("id입력"));
					member.setName(input("new name"));
					member.setPassword(input("new pw"));
					member.setEmail(input("new email"));
					member.setPhone(input("new phone"));
					member.setProfileImg(input("new profile image"));
					service.change(member);
					break;
				case "4":
					member = new MemberBean();
					member.setId(input("삭제할 id입력"));
					service.remove(member);
					break;
				case "5":
					member = new MemberBean();
					member.setId(input("ID"));
					member.setPassword(input("Password"));
					if(service.login(member)) {
						System.out.println("로그인 성공");
					} else {
						System.out.println("로그인 실패");
					}
					break;
				case "0":
					return;
				}
			}
		} catch (Exception e) {
			
		}
	}
	
	public static String input(String str) {
		return JOptionPane.showInputDialog(str);
	}
}
