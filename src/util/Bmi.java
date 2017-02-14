package util;

public class Bmi {
	public String[] getBmi(int age, double weight, double height) {
		String result[] = new String[2];
		if(age>2) {
			result[0] = String.valueOf(age);
			double bmi = weight / (height * height);
			if(bmi>30) {
				result[1] = "고도비만";
			} else if(bmi>25) {
				result[1] = "비만";
			} else if(bmi>23) {
				result[1] = "과체중";
			} else if(bmi>18.5) {
				result[1] = "정상";
			} else {
				result[1] = "저체중";
			}
		} else {
			result[0] = "2살 이하는 측정이 불가능합니다.";
			result[1] = "측정 불가";
		}
		return result;
	}
}