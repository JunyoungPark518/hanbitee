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
				switch (input("1.가입/2.로그인/3.수정/4.삭제/0.종료")) {
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
					if(service.join(member)==1) {
						JOptionPane.showMessageDialog(null, "가입이 완료되었습니다");
					} else {
						JOptionPane.showMessageDialog(null, "가입에 실패하였습니다");
					}
					break;
				case "2":
					member = new MemberBean();
					member.setId(input("id"));
					member.setPassword(input("password"));
					if(service.login(member)) {
						JOptionPane.showMessageDialog(null, "로그인성공");
					} else {
						JOptionPane.showMessageDialog(null, "로그인실패");
					}
					break;
				case "3":
					member = new MemberBean();
					member.setId(input("id입력"));
					member.setPassword(input("new pw"));
					member.setEmail(input("new email"));
					member.setPhone(input("new phone"));
					member.setProfileImg(input("new profile image"));
					if(service.change(member)==1) {
						JOptionPane.showMessageDialog(null, "변경 성공");
					} else {
						JOptionPane.showMessageDialog(null, "변경 실패");
					}
					break;
				case "4":
					member = new MemberBean();
					member.setId(input("삭제할 id입력"));
					if(service.remove(member)==1) {
						JOptionPane.showMessageDialog(null, "ID 삭제 성공");
					} else {
						JOptionPane.showMessageDialog(null, "ID 삭제 실패");
					}
					break;
				case "0":
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String input(String str) {
		return JOptionPane.showInputDialog(str);
	}
}
