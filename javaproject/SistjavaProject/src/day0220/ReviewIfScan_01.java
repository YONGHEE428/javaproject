package day0220;

import java.util.Scanner;

public class ReviewIfScan_01 {

	public static void main(String[] args) {
		/*
		 * 이름을 입력하세요
		 * 홍길동
		 * 정보처리기사 3과목의 점수를 입력하세요(junga,jungb,jungc)
		 * 88 77 39
		 * =============================================
		 * 3과목의 평균: **.**점
		 * =============================================
		 * **합격조건: 평균이60점이상이고 각과목이 모두 40점이상이면 합격**
		 * ==============================================
		 * 홍길동님은 불합격입니다
		 */
		
		Scanner sc=new Scanner(System.in);
		String name;
		int junga,jungb,jungc;
		
		System.out.println("이름을 입력하세요");
		name=sc.nextLine();
		System.out.println("정보처리기사 3과목의 점수를 입력하세요");
		junga=sc.nextInt();
		jungb=sc.nextInt();
		jungc=sc.nextInt();
		
		double avg=(junga+jungb+jungc)/3.0;
		
		//출력
		System.out.println("============================");
		System.out.printf("3과목의 평균:%.2f점\n",avg);
		System.out.println("============================");
		System.out.println("**합격조건: 평균이60점이상이고 각과목이 모두 40점이상이면 합격**");
		System.out.println("============================");
		
		//if문
		if(junga>=40&&jungb>=40&&jungc>=40&&avg>=60)
			System.out.println(name+"님은 합격입니다");
		else
			System.out.println(name+"님은 불합격입니다");
		
		
		
		
		
		
		
		
		
		
		
		

	}

	
}
