package day0221;

import java.util.Scanner;

public class Quiz0221 {

	public static void quiz01 () {
		
		Scanner sc = new Scanner(System.in);
		int x=0, y=0;
		for (int i=1; i <=5; i++)
		{
			System.out.print("5개의 숫자를 입력하시오. ");
			int num = Integer.parseInt(sc.nextLine());
			
			if (num >=0)
				x++;
			if (num < 0)
				y++;
		}
		System.out.println("=======================");
		System.out.println("양수갯수 : " +x);
		System.out.println("음수갯수 : " + y);
		
	}
	public static void quiz02 () {
		
		Scanner sc = new Scanner(System.in);
		
		int a = 0, b = 0, c = 0;
		
		while (true)
		{
			System.out.print("나이를 입력해주세요 : ");
			int age = Integer.parseInt(sc.nextLine());
			
			if (age == 0)
			{
				break;
			}
			if (age >= 50)
			{
				a++;
			}
			else if (age >= 30)
				b++;
			else
				c++;
		}
		System.out.println("================");
		System.out.println("50세 이상 : "+a+"명");
		System.out.println("30세 이상 : "+b+"명");
		System.out.println("그 이외 : "+ c+"명");
		
	}
	public static void main(String[] args) {
		quiz01 ();
		System.out.println("=====================");
		quiz02 ();
	}
}
123