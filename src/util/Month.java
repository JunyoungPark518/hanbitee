package util;

public class Month {
	public String month(int year, int month) {
		String output = "";
		if(month==2) {
			if(year%4 == 0 && year%100 == 0 && year%400 == 0) {
				output = "28";
			} else {
				output = "29";
			}
		} else if(month%2==1 && month<8 || month==10 || month==12) {
			output = "31";
		} else {
			output = "30";
		}
		return output;
	}
}
