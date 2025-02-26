package day0226;

import java.util.Scanner;

public class ReviewQuiz_07 {

	public static void quiz1 ()
	{
		//문제1. 숫자 n을 입력하면 1부터 n까지의 합계를 구하시오.
		
		Scanner sc = new Scanner(System.in);
		int n;
		int sum = 0;
		
		System.out.print("숫자를 입력하시오 : ");
		n = Integer.parseInt(sc.nextLine());
		
		for (int i = 1; i <= n; i++)
			sum += i;
		
		System.out.println("1부터 "+ n + "까지의 합계: " + sum);
		
	}
	
	public static void quiz2 ()
	{
		//문제2. 5명의 나이를 입력후 40세 이상과 40세 미만이 각각 몇명인지 출력하고
		// 평균도 구하시오
		
		Scanner sc = new Scanner(System.in);
		int age;
		int up = 0;
		int down = 0;
		int tot = 0;
		double val;
		
		System.out.println("5명의 나이를 입력하시오");
		for( int i = 1; i <=5 ; i++) {
			System.out.print(i + "번째 사람의 나이 : ");
			age = Integer.parseInt(sc.nextLine());
			tot += age;
			
			if (age >= 40) {
				up++;
			}else
				down++;
		}
		val = tot / 5.0;
		System.out.println("===========================");
		System.out.println("40세 이상 인원수 : "+up);
		System.out.println("40세 미만 인원수 : "+down);
		System.out.printf("평균 나이 : %.2f\n",val);
	}
	public static void quiz3 ()
	{
		//배열에 1~50사이의 난수 20개를 구하여 넣고
		// 오름차순 정렬 후 출력
		
		int [] a = new int [20];
		
		for (int i = 0; i < 20; i ++) {
			a[i] = (int)(Math.random()*50)+1;
			for(int j = 0; j <i; j++) {
				if (a[i]==a[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println("==============정렬 전=============");
		for(int n : a)
			System.out.print(n + " ");
		System.out.println();
		
		for (int i = 0; i < 19; i ++) {
			for (int j = i+1; j < 20; j++) {
				if (a[i]>a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println("==========오름차순 정렬 후===========");
		for(int n : a)
			System.out.print(n + " ");	
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("------------첫번째 문제------------");
		quiz1();
		System.out.println("------------두번째 문제------------");
		quiz2();
		System.out.println("------------세번째 문제------------");
		quiz3();
	}
}
