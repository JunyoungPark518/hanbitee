package util;

public class PathRefiner {
	public static String[] getAll(String path) {
		String[] dir = new String[4];
		dir[0] = "/WEB-INF/jsp/" + path.split("/")[1] + "/";
		dir[1] = path.split("/")[2].split("\\.")[0];
		dir[2] = ".jsp";
		dir[3] = dir[0] + dir[1] + dir[2];
		return dir;
	}
	
	public static String getAction(String path) {
		return path.split("/")[2].split("\\.")[0];
	}
	
	public static String getFullPath(String path) {
		return "/WEB-INF/jsp/" + path.split("/")[1] + "/" + path.split("/")[2].split("\\.")[0] + ".jsp";
	}
	
	public static String getDirectory(String path) {
		return "/WEB-INF/jsp/" + path.split("/")[1] + "/";
	}
	
	public static String getQueryStringKey(String url, int number) {
		return url.split("?")[1].split("&")[number-1].split("=")[0];
	}
	
	public static String getQueryStringValue(String url, String queryString) {
		for(int i=0; i<(new PathRefiner().qsCount(url)); i++) {
			String[] qs = url.split("?")[1].split("&")[i-1].split("=");
			if(qs[0].equals(queryString)) {
				return qs[1];
			}
		}
		return null;
	}
	
	public static String getQueryStringValue(String url, int number) {
		return url.split("?")[1].split("&")[number-1].split("=")[1];
	}
	
	public int qsCount(String url) {
		int count=0;
		String temp = url.split("?")[1];
		for(int i=0; i<url.length(); i++) {
			if(temp.charAt(i)=='=') {
				count++;
			}
		}
		return count;
	}
}
