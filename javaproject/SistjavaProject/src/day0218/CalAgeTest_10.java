package day0218;

import java.util.Calendar;

public class CalAgeTest_10 {

	public static void main(String[] args) {
		// 자바 실행시 이름과 태어난 연도를 입력하면 나이를 구할 수 있다
		//args 변수 이용해서 해볼것
		
		//import
		Calendar cal = Calendar.getInstance();
		
		//변수선언
		
		String name = args[0];
		int birth = Integer.parseInt(args[1]);
		//현재 년도
		int culYear = cal.get(cal.YEAR);
		
		//계산
		int age = culYear - birth;
		
		System.out.printf("내 이름은 %s입니다.\n태어난 연도는 %d년도입니다.\n나이는 %d세 입니다.", name, birth, age);

		
		
	}

}
