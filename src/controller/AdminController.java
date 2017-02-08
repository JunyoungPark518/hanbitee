package controller;

import javax.swing.JOptionPane;

import enums.Butt;
import domain.MemberBean;
import service.AdminService;
import serviceImpl.AdminServiceImpl;

public class AdminController {
	public void start(){
		MemberBean member=null;
		AdminService service = new AdminServiceImpl();//기능을 다 가지고 있으므로 무조건 생성
		Butt[] buttons ={Butt.CLOSE,Butt.MEMBER_ADD,Butt.FIND_BY_ID,Butt.FIND_BY_NAME,Butt.MAP_FIND_BY_NAME,Butt.LIST,Butt.UPDATE,Butt.DELETE,Butt.KEY_LIST};
		while(true){
			Butt select=(Butt)JOptionPane.showInputDialog(
					null, //frame
					"ADMIN PAGE", //frame title
					"SELECT ADMIN MENU", //order
					JOptionPane.QUESTION_MESSAGE, //type
					null, //icon
					buttons, //Array of choices
					buttons[1] //default
					);
			switch(select){
			default:	
			case CLOSE:JOptionPane.showConfirmDialog(null, "EXIT Ok??");return;
				case MEMBER_ADD:
					member = new MemberBean();
					String[] memberInfoArr=input("아이디, 비밀번호, 이름, 주민등록번호, 이메일, 프로필사진, 휴대폰번호").split(" ");
					member.setId((memberInfoArr[0]));
					member.setPassword((memberInfoArr[1]));
					member.setName((memberInfoArr[2]));
					member.setSsn((memberInfoArr[3]));
					member.setEmail((memberInfoArr[4]));
					member.setProfileImg((memberInfoArr[5]));
					member.setPhone((memberInfoArr[6]));
					member.setRank("C");
					service.register(member);
					break;
				case FIND_BY_ID:
					member = new MemberBean();
					member=service.findById(input("검색할 아이디를 입력하세요."));
					showMsg((member==null)?"회원이 존재하지 않습니다.":member.toString());
					break;
				case FIND_BY_NAME:
					String nameResult=input("검색할 이름을 입력하세요.");
					showMsg((service.count()==0)?"회원이 존재하지 않습니다.":service.findByName(nameResult).toString());
					break;
				case MAP_FIND_BY_NAME:
					String mapNameResult=input("검색할 이름을 입력하세요.");
					showMsg((service.count()==0)?"회원이 존재하지 않습니다.":service.findMapByName(mapNameResult).toString());
					break;
				case LIST:
					showMsg((service.count()==0)?"회원이 존재하지 않습니다.":service.memberList().toString());
					break;
				case UPDATE:
					member=new MemberBean();
					member.setId(input("변경할 아이디를 입력하세요."));
					member.setName(input("변경할 이름을 입력하세요."));
					member.setPhone(input("변경할 휴대폰 번호를 입력하세요."));
					member.setEmail(input("변경할 email를 입력하세요."));
					service.update(member);
					break;
				case DELETE:
					service.remove(input("삭제 할 아이디를 입력하세요."));
					break;
				case KEY_LIST:
					showMsg(service.keyList().toString());
					break;
				
			}
		}
	}
	public String input(String str){
		return JOptionPane.showInputDialog(str);
	}
	public void showMsg(String str){
		JOptionPane.showMessageDialog(null, str);
	}
}
