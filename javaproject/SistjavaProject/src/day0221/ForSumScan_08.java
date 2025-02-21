package day0221;

import java.util.Scanner;

public class ForSumScan_08 {

		public static void main(String[] args) {
			// 점수를 3번 반복해서 입력 후 합계를 구하시오.(1~100까지 입력할것)
			// 해당범위를 벗어나면 잘못 입력했습니다. 하고 재입력 
			Scanner sc =new Scanner(System.in);
			int sum = 0;
			int i = 1;
			
			/*for (i = 1; i <=3; i ++)
			{
				System.out.print(i+"번째점수를 입력하시오(1~100) : ");
				int num = Integer.parseInt(sc.nextLine());
				System.out.println("===============================");
				if(num <1 || num >100)
				{
					System.out.println("다시 입력해주세요\n1~100까지의 숫자만 입력해주세요");
					System.out.println("===============================");

					i--;
				}
			    sum += num;
			}
			System.out.println("합계 : " + sum );*/
			
			while (i <=3) {
				System.out.print(i + "번째 점수를 입력하시오(1~100) : ");
				int num = Integer.parseInt(sc.nextLine());
				System.out.println("===============================");
				
				if(num <1 || num > 100)
				{
					System.out.println("점수를 잘 못 입력하셨습니다. 다시 입력하시오");
					System.out.println("===============================");
					continue;
				}
				sum +=num;
				i++;
			}
			System.out.println("합계 : " + sum);
		
			
		}
}
