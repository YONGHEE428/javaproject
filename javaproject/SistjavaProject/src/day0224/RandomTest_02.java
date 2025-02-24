package day0224;

import java.util.Random;
import java.util.Scanner;

public class RandomTest_02 {

	public static void main(String[] args) {
		// Math.random() , Random클래스 생성  == Random 함수
			
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("난수 생성");
		
		for (int i = 1; i <= 5; i++)
		{
			int r = rand.nextInt(10)+1;
			System.out.println(r + "\t");
		}
		System.out.println("=========================");
		
		//Math.random()
		for (int j =1; j <=5; j++)
		{
			int a = (int)(Math.random()*26)+65;
			System.out.println(a + "\t");
		}
		System.out.println("====================");
		for (int i =1; i <= 5; i++)
		{
			int n =rand.nextInt(26)+65;
			System.out.println((char)n);
		}
		}
}
