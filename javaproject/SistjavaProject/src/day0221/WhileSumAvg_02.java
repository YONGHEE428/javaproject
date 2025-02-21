package day0221;

import java.util.Scanner;

public class WhileSumAvg_02 {

	public static void main(String[] args) {
		// 임의의 숫자를 입력하여, 합계 ,평균
		// 단 0을 입력하면 반복문을 빠져나간다.
		
		
		Scanner sc = new Scanner(System.in);
		
		int num;
		int sum = 0, i =0;
		double avg = 0;
		
		while(true) {
			System.out.print("숫자를 입력하시오 : ");
			num = Integer.parseInt(sc.nextLine());
			
			if(num == 0) {
				System.out.println("종료합니다.");
				break;
			}
			sum += num;
			i++;
		}
		System.out.println("===========================");
		System.out.println("숫자 입력 횟수 : " + i);
		avg = (double)sum / i;
		System.out.println("숫자들의 합계는 "+ sum +"이며, 평균은 " + avg + "입니다.");
		
		
	}
}
