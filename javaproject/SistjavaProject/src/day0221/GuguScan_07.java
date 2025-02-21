package day0221;

import java.util.Scanner;

public class GuguScan_07 {

	public static void main(String[] args) {
		//원하는 구구단 입력
		
		Scanner sc = new Scanner(System.in);
		
		n1 : while (true)
		{
			System.out.print("숫자를 입력하시오: ");
			int num = Integer.parseInt(sc.nextLine());
			
			if (num ==0) {
				System.out.println("종료합니다.");
				break;
			}
			if (num <= 1 || num >=10)
			{
				System.out.println("잘 못 입력하셨습니다. \n2 ~ 9단 까지만 입력해주세요");
				continue;
			}
			for(int j = 1; j <= 10; j++)
			{
				System.out.printf("%d x %d = %d \t",num,j,num*j);
			}
			System.out.println("");
		
			System.out.println("=============================================================================================================================================================");

			/*for(int j = 1; j <= 10; j++)
			{
				System.out.printf("%d x %d = %d \n",num,j,num*j);
			}
			System.out.println("");*/
		}
	}
}
