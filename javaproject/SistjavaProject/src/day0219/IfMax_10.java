package day0219;

import java.util.Scanner;

public class IfMax_10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x, y, z,max;
		
		System.out.println("3개의 수를 입력하시오.");
		x = sc.nextInt();
		y = sc.nextInt();
		z = sc.nextInt();
		
		// If문
	/*	max = x;
		if (max < y) 
			max = y;
		if (max < z) 
			max = z;
		*/
		if (x > y && x > z)
			max = x;
		else if(y > x && y > z)
			max = y;
		else
			max = z;
		System.out.println("max = " + max);
			
		// 삼향연산자
		max = x >= y && x >= z ? x : (y >= z ? y : z);
		
		System.out.println("Max = " + max);
		
	}
}
