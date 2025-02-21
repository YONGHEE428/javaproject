package day0219;

import java.util.Scanner;

public class IfMax_10 {

	public static void main(String[] args) {
		/*
		 * 3개의 수를 입력하시오 (A && B  A B 모두 true여야 true)
		 * 5 
		 * 15
		 * 8
		 * ***if문***
		 * max=15
		 * ***삼항연산자***
		 * max=15
		 */
		Scanner sc=new Scanner(System.in);
		int x,y,z,max;
		
		System.out.println("세개의 숫자를 입력하시오");
		x=sc.nextInt();
		y=sc.nextInt();
		z=sc.nextInt();
		
		System.out.println("***if문***");
		if(x>y && x>z)
			max=x;
		else if(y>x && y>z)
			max=y;
		else
			max=z;
		System.out.println("max="+max);
		/////////////////////////////////////////
		
		System.out.println("***삼항연산자***");
		max=x>y&&x>z?x:y>z&&y>x?y:z;
		System.out.println("max="+max);
		
		

	}

}
