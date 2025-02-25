package day0224;

import java.util.Scanner;

public class Quiz0224 {

	public static void main(String[] args) {
		// 번호 이름 자바 오라클 스프링 총점 평균 등수
		Scanner sc = new Scanner(System.in);
		
		int a = 0;
		System.out.print("확인할 인원 수를 정하시오 : ");
		a = Integer.parseInt(sc.nextLine());
		/*String [] name = {"현승훈","이우형","박창배","최태림"};
		int [] java = {90,77,88,46};
		int [] oracle = {89,56,79,98};
		int [] spring = {100,89,99,79};*/
		String [] name = new String[a];
		int [] java = new int [a];
		int [] oracle = new int [a];
		int [] spring = new int [a];
		int [] tot = new int[a];
		double [] avg = new double[a];
		int [] rank = new int [a];
	
		for (int i =0; i < a; i++)
			{
			System.out.print("이름 : ");
			name[i] = sc.nextLine();
			System.out.print("Java 점수 : ");
			java[i] = Integer.parseInt(sc.nextLine());
			System.out.print("Oracle 점수 : ");
			oracle[i] = Integer.parseInt(sc.nextLine());
			System.out.print("Spring 점수 :");
			spring[i] = Integer.parseInt(sc.nextLine());
			}
		
		System.out.println("\n번호\t이름\t자바\t오라클\t스프링\t총점\t평균\t등수");
		System.out.println("===========================================================");
		
		
		
		for (int i = 0; i < a; i++)
		{
			tot[i] = java[i]+oracle[i]+spring[i];
			avg[i] = (double) tot[i] / 3;
		}
		
		for(int i =0; i <a; i++)
		{	
			rank[i] = 1;
			for(int j = 0; j < a; j++)
			{
				if (tot[i]<tot[j])
					rank[i] ++;
			}
		}
		for (int i = 0; i < a; i++)
			
			//System.out.println((i+1) + "번\t" + name[i] + "\t" + java[i] + "\t" + oracle[i] + "\t" + spring[i] + "\t" + tot[i] + "\t" + avg[i] + "\t" + rank[i]);
			System.out.printf("%d번\t%s\t%d점\t%d점\t%d점\t%d점\t%.2f점\t%d등\n",(i+1),name[i],java[i],oracle[i],spring[i],tot[i],avg[i],rank[i]);
		
		
	
	}
}
