package day0225;

import java.util.Scanner;

public class ex_10 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String num; //번호 선택
		int n= 0; //학생수
		int [] scorelist = null; //점수
		int tot;
		double val;
		while(true) 
		{
			
			System.out.println("-----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3. 점수리스트 | 4. 분석 | 5.종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택> ");
			num = sc.nextLine();
			
			if (num.equals("5"))
			{	
				System.out.println("프로그램 종료");
				break;
			}
			if (num.equals("1"))
			{
				
				System.out.print("학생 수를 입력하시오 : ");
				n = Integer.parseInt(sc.nextLine());
				scorelist = new int [n];
				
			}
			if (num.equals("2"))
			{
				for (int i = 0; i < n; i++)
				{
					System.out.print("scores["+i+"]> " );
					scorelist[i] = Integer.parseInt(sc.nextLine());
					tot += scorelist[i];
				}
				
			}
			if (num.equals("3"))
			{
				for(int i = 0; i < n; i++)
				{
					System.out.print("score[" + i + "]: ");
					System.out.println(scorelist[i]);
				}
			}
			if (num.equals("4"))       //나중엔 case문 으로 간결화 가능
			{
				
			}			
		}
	}
}
