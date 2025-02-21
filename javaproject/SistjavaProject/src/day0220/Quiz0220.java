package day0220;

import java.util.Scanner;

public class Quiz0220 {
	
		public static void main(String[] args) {
			
			
			Scanner sc =new Scanner(System.in);
			
			int sum = 0;
			int nu;
			
			System.out.println("합계를 구할 숫자는? ");
			nu = sc.nextInt();
			
			for (int i =0; i<=nu; i++)
				sum +=i;
			
			
			System.out.println(nu+"까지의 숫자들의 합은 : " + sum);
		}
	
}
