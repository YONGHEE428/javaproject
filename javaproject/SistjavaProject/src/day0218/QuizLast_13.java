package day0218;

import java.util.Calendar;
import java.util.Scanner;

public class QuizLast_13 {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		
		
		String name, job;
		int birth, age;
		
		System.out.println("당신의 이름은?");
		name = sc.nextLine();
		
		System.out.println("당신의 출생년도는?");
		birth = Integer.parseInt(sc.nextLine());
		
		System.out.println("당신의 직업은?");
		job = sc.nextLine();
		
		int now = cal.get(cal.YEAR);
		
		
		age = now - birth;
		
		System.out.println("=====================================");
		System.out.printf("%s님은 %d생이며 %d세입니다. 직업은 %s입니다.",name, birth,age,job );
	}

}
