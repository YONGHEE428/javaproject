package day0221;

import java.util.Random;

public class RandomTest_12 {

	public static void main(String[] args) {
		// 자바에서 난수를 구하는 방법은 2가지
		//1. Math.random() 메소드를 이용하는 방법
		//2. Random이라는 클래스를 생성하여 구하는 방법
		
		Random rand = new Random();
		
		System.out.println("\t\t\t\t\t\t\t기본난수 5개 발생");
		
		
		for(int i=1; i<=5; i++)
		{
			double num = Math.random();
			System.out.print(num + "\t");
		}
		System.out.println("");
		System.out.println("=======================================");
		System.out.println("\t\t0~9");
		for(int i=1; i<=5; i++)
		{
			int num = (int)(Math.random()*10);
			System.out.print(num + "\t");
		}
		System.out.println("");
		System.out.println("=======================================");
		System.out.println("\t1~10사이의 난수 5개");
		for(int i=1; i<=5; i++)
		{
			int num = (int)(Math.random()*10)+1;
			System.out.print(num + "\t");
		}
		System.out.println("");
		System.out.println("=======================================");
		System.out.println("\t1 ~ 100 사이에 난수");
		for(int i=1; i<=5; i++)
		{
			int num = (int)(Math.random()*100)+1;
			System.out.print(num + "\t");
		}
	}
}
