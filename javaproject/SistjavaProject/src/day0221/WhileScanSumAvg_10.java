package day0221;

import java.util.Scanner;

public class WhileScanSumAvg_10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int i=1;
		int sum = 0;
		double avg = 0;
		String num;
		
		while (true) {
			System.out.print(i+"번째 점수를 입력해 주세요(1~100까지의 점수만 입력하세요): ");
			num = sc.nextLine();
			
			/*if (Integer.parseInt(num) == 0)
			{
				System.out.println("\n\t     점수 입력을 종료합니다.");
				i--;
				break;
			}*/
			//q나 Q로 종료시키기
			
			if (num.charAt(0)=='q' || num.charAt(0)=='Q')
			{	
				System.out.println("\n\t     점수 입력을 종료합니다.");
				i--;
				break;
			}
			if (Integer.parseInt(num) < 1 || Integer.parseInt(num) > 100)
			{
				System.out.println("\t  점수를 잘 못 입력 했습니다.");
				continue;
			}
			
			i++;
			sum +=Integer.parseInt(num);
		
		}
		avg = (double)sum / i;
		
		System.out.println("\n==========================================");
		System.out.println("\t\t총 개수 : " +i + "개" );
		System.out.println("\t\t총점 : "+sum + "점");
		System.out.println("\t\t평균 : "+avg + "점");
		
		
	}
}
