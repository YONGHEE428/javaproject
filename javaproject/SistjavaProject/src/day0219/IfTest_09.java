package day0219;

import java.util.Scanner;

public class IfTest_09 {

	public static void main(String[] args) {
		 // 두수를 입력하여 더 큰값 구하기
		
		Scanner sc = new Scanner(System.in);
		int x,y,max;
		
		System.out.println("두 수를 입력하세요");
		x = sc.nextInt();
		y = sc.nextInt();
		
		System.out.println("입력한 두 수 : " + x + ", " + y);
		
		
		if (x>y) 
			max = x;
		else 
			max = y;
		System.out.println("두 수중 더 큰 값은 : " + max + "입니다.");
	
		max = x > y ? x : y;
		System.out.println("두 수중 더 큰 값은 : " + max + "입니다.");
	
		
		
		
	}
}
