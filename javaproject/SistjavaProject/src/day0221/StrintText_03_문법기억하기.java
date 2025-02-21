package day0221;

import java.util.Scanner;

public class StrintText_03_문법기억하기 {

	public static void main(String[] args) {
		//equals. startWith, endWith사용
		//김씨가 몇명인지
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int cnt = 0;
		int cnt2 = 0;
		
		while(true) {
			System.out.print("이름입력 (종료 = '끝') : ");
			name = sc.nextLine();

			//break
			
			if(name.equals("끝"))
				break;
			
			if (name.startsWith("김"))
				cnt++;
			if (name.endsWith("용"))
				cnt2++;
			
		}
		
		System.out.println("김씨는 총 " + cnt + "명입니다.");
		System.out.println("이름의 끝이 '용' 인사람은 총 " + cnt2 + "명입니다");
	}
}
