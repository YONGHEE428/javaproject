package day0226;

import java.util.Scanner;

public class ArrayDachaScore_05 {

	public static void main(String[] args) {
		//다차원 배열로 성적표 출력
		/*
		 * 이름 자바 오라클 스프링 총점
		 * 이효리 88 77    99**
		 * 이상순 77 75   77 **
		 * 김민희 66 77    44**
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String [] name = {"이효리","이상순","김민희"};
		int [] [] score = {{88,77,99,0},{77,75,77,0},{66,77,44,0}};
		
		System.out.println("이름\t자바\t오라클\t스프링\t총점");
		
		for (int i=0; i<name.length;i++) {
			for(int j = 0; j<score[i].length-1; j++) {
				score[i][score[i].length-1] += score[i][j];
			}
		}
		
		for (int i=0; i<name.length;i++) {
			System.out.print(name[i] + "\t");
			for(int j = 0; j<score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
