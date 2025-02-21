package day0221;

import java.util.Scanner;

public class ForScanSum_09 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		/*int sum = 0;
		int n =1,i;
		double avg = 0;
		for (i =1; i <=5; i++) {
			System.out.print(i+"번째 점수를 입력해주세요(1~100까지의 점수만 입력하세요) : ");
			int num = Integer.parseInt(sc.nextLine());
			if ( num < 1 || num > 100)
			{
				System.out.println("\t\t잘 못 입력 했어요");
				i--;
				continue;
			}
			sum += num;
		}
		avg = (double)(sum / (i-1));
		
		System.out.println("===========================");
		System.out.println("총점 : "+sum);
		System.out.println("평균 : "+avg);*/
		
		int i=1;
		int sum = 0;
		double avg = 0;
		
		while (true) {
			System.out.print(i+"번째 점수를 입력해 주세요(1~100까지의 점수만 입력하세요): ");
			int num = Integer.parseInt(sc.nextLine());
			
			if (num == 0)
			{
				System.out.println("점수 입력을 종료합니다.");
				i--;
				break;
			}
			if (num < 1 || num > 100)
			{
				System.out.println("\t\t점수를 잘 못 입력 했습니다.");
				continue;
			}
			
			i++;
			sum +=num;
		
		}
		avg = (double)sum / i;
		
		System.out.println("==========================="+i);
		System.out.println("총점 : "+sum);
		System.out.println("평균 : "+avg);
		
	}
}
