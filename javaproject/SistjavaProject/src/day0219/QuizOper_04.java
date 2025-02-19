package day0219;

import java.util.Scanner;

public class QuizOper_04 {

	public static void main(String[] args) {
		//현재 지갑에 있는 돈을 입력하여, 만원, 천원, 백원, 일원 개수를 출력하시오.
		
		
		Scanner sc = new Scanner(System.in);
		
		int money;
		
		
		System.out.print("금액을 입력하시오 : ");
		money = Integer.parseInt(sc.nextLine());
		
		System.out.println("만원 : " + money/10000);
		money = money % 10000;
		System.out.println("천원 : " + money/1000);
		money = money % 1000;
		System.out.println("백원 : " + money/100);
		money = money % 100;
		System.out.println("십원 : " + money/10);
		money = money % 10;
		System.out.println("일원 : " + money);
		
		
	}
}
