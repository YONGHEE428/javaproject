package day0219;

import java.util.Scanner;

public class Quiz0219_12 {

	public static void main(String[] args) {
		
		Scanner cs = new Scanner(System.in);
		
		System.out.println("숫자를 입력하시오");
		int num = cs.nextInt();
		
		if (num % 2 == 0)
			System.out.println(num+"은 짝수");
		else
			System.out.println(num+"은 홀수");
		
		//삼향연산자
		
		System.out.println("**삼향연산자**");
		System.out.println(num%2==0? num+"은 짝수" : num + "은 홀수");
	}
}
