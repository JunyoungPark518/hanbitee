package util;

public class SSNGenerator {
	public static String getSsn(String birth, String gender) {
		if(Integer.parseInt(birth.substring(0,2))<20) {
			birth += (gender.equals("M")) ? "-1" : "-2";
		} else {
			birth += (gender.equals("M")) ? "-3" : "-4";
		}
		return birth;
	}
}
