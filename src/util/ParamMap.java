package util;

import javax.servlet.http.HttpServletRequest;

public class ParamMap {
	public static String getValues(HttpServletRequest request, String param) {
		String rs = "";
		String[] values = (String[]) request.getParameterMap().get(param);
		for(String s : values) {
			rs += s + ",";
		}
		rs.substring(0, rs.length()-2);
		System.out.println(rs);
		return rs;
	}
}
