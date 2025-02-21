package day0221;

import java.util.Scanner;

public class RandomSuMatch_13 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int i = (int)(Math.random()*10)+1;
		System.out.println("랜덤 수 맞추기 (1~10)");
		System.out.println("====================");
		/*while(true)
		{
			System.out.print("숫자를 입력해주세요: ");
			int num = Integer.parseInt(sc.nextLine());
			
			if(num == i)
			{
				System.out.println("======================");
				System.out.println("추카합니다. 정답입니다.");
				break;
			} else
				System.out.println("\t떙!");
		}*/
		while(true)
		{
			System.out.print("숫자를 입력해주세요 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			if(num > i)
			{
				System.out.println(num + " 보다 작습니다.");
			}else if (num < i)
			{
				System.out.println(num + " 보다 큽니다.");
			}else {
				System.out.println("정답입니다. 정답은" + i + " 였습니다!");
				break;
				}
		}
		
	}
}