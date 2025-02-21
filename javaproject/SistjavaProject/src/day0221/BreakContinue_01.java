package day0221;

import java.util.Scanner;

public class BreakContinue_01 {
	
	public static void main(String[] args) {
		// 0을 입력시 빠져나오게 입력
		//입력한 점수 합계
		
		Scanner sc = new Scanner(System.in);
		int sum =0;
		int score;
		
		
		while(true) {
			System.out.println("점수를 입력하세여");
			score = sc.nextInt();
			
			if(score ==0)
				break;
			if (score <0 || score >100)
				continue; // 다시점수 입력
			
			sum +=score;
		}
		System.out.println("점수 총 합계 : " + sum);
	}
}
