package day0219;

import java.util.Scanner;

public class IfTest_09 {

	public static void main(String[] args) {
		// 두수를 입력하여 더큰값 구하기
		Scanner sc=new Scanner(System.in);
		int x,y,max;
		
		System.out.println("두수를 입력하세요");
		x=sc.nextInt();
		y=sc.nextInt();
		
		System.out.println("입력한 두수: "+x+","+y);
		
		//max값 if문으로 구하기 
		if(x>y)
			max=x;
		else
			max=y;
		System.out.println("if문: 두수중 더 큰값은 "+max+"입니다");
			
		//max값 삼항(조건)연산자로 구하기
		//조건식?참값:거짓값
		max=x>y?x:y;
		System.out.println("삼항연산자:두수중 더 큰값은 "+max+"입니다");
		
		System.out.println("첫번째수가 더"+(x>y?"크다":"작다"));

	}

}
