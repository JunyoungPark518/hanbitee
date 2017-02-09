package util;

import javax.swing.JOptionPane;

import dao.MemberDAO;
import daoImpl.MemberDAOImpl;
import domain.MemberBean;

public class DAOTest {
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAOImpl();
		MemberBean member = null;
		String[] temp = null;
		while(true) {
			switch (input("1.가입/2.조회/3.수정/4.삭제/0.종료")) {
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
				dao.insert(member);
				break;
			case "2":
				member = new MemberBean();
				member = dao.selectById(input("id입력"));
				JOptionPane.showMessageDialog(null, member.toString());
				break;
			case "3":
				member = new MemberBean();
				member = dao.selectById(input("id입력"));
				switch(input("1.pw/2.email/3.phone/4.profile img/0.exit")) {
				case "1":
					member.setPassword(input("new pw"));
					break;
				case "2":
					member.setEmail(input("new email"));
					break;
				case "3":
					member.setPhone(input("new phone"));
					break;
				case "4":
					member.setProfileImg(input("new profile image"));
					break;
				case "0":
					return;
				}
				dao.update(member);
				break;
			case "4":
				member = new MemberBean();
				member.setId(input("삭제할 id입력"));
				dao.delete(member);
				break;
			case "0":
				return;
			}
		}
	}
	
	public static String input(String str) {
		return JOptionPane.showInputDialog(str);
	}
}
