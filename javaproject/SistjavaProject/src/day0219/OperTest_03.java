package day0219;

import java.util.Scanner;

public class OperTest_03 {

	public static void main(String[] args) {
		//산술연산자
		
		Scanner sc = new Scanner(System.in);
		
		int x,y;
		
		System.out.print("첫번째 수를 입력하시오 : ");
		x = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 수를 입력하시오 : ");
		y = Integer.parseInt(sc.nextLine());
		
		System.out.println("더하기 = " + (x+y));
		System.out.println("빼기 = " + (x-y));
		System.out.println("곱하기 = " + (x*y));
		System.out.println("나누기 = " + (double)x/y);
		System.out.println("나머지 = " + (x%y));
		
		
	}
}
