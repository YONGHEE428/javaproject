package day0225;

import java.util.Scanner;

public class QuizLottoBuy_08 {

	public static void main(String[] args) {
		// 로또 
		Scanner sc = new Scanner(System.in);
		
		int [] lotto = new int[6];
		int a;
		
		System.out.print("로또 몇장드릴까요? " );
		a = Integer.parseInt(sc.nextLine());
		
		for(int k =0; k <a; k++) {
			for (int i = 0; i <lotto.length; i++) {
				lotto[i] = (int)(Math.random()*45+1);
				for(int j = 0; j <i; j++) {
					if (lotto[i]==lotto[j]) {
						i--;
						break;
					}
				}
			}
		System.out.print((k+1)+"회 : ");	
		for (int n : lotto)
			System.out.print( n + " ");
		System.out.println("");	
		}
	
	}
}
