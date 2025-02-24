package day0224;

import java.util.Scanner;

public class FindArrayScanMaxMinRank_12 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int a = 0;
		
		System.out.print("입력할 인원 수를 정하시오 : ");
		a = Integer.parseInt(sc.nextLine());
		
		String [] name = new String[a];
		int [] score = new int [a];
		int [] rank = new int [a];
		int tot =0;
		double avg = 0;
		int max = 0;
		int min = 0;
		String maxName = "";
		String minName = "";
		for (int i =0; i < a; i++)
		{
			System.out.print((i+1) + "번째 사람의 이름을 입력하시오 : ");
			name[i] = sc.nextLine();
			System.out.print((i+1) + "번째 사람의 점수를 입력하시오 : ");
			score[i] = Integer.parseInt(sc.nextLine());
			tot +=score[i]; 
		}
		max = score[0];
		min = score[0];
		maxName = name[0];
		minName = name[0];

		
		for(int k = 1; k <a; k++)
		{
			if (max < score[k])
			{
				max = score[k];
				maxName = name[k];
			}
			if (min > score[k])
			{
				min = score[k];
				minName = name[k];
			}
		}
		for(int i = 0; i < a; i++)
		{
			rank[i] = 1;
			for(int j = 0; j < a; j++)
				if(score[i]<score[j])
					rank[i]++;
		}
		
		
		avg = (double)tot / a;
		
		System.out.println("=============================");
		System.out.println("번호\t이름\t점수\t등수");
		System.out.println("-----------------------------");
		for (int j = 0; j < name.length; j++)
			System.out.println((j+1) +"번\t"+ name[j] + "\t" + score[j] +"\t"+ rank[j]);
		System.out.println("=============================");
		System.out.println("총 합계 : " + tot + " || 평균 : " + avg);
		System.out.println("1등 : " + maxName + " || 점수 : "+max);
		System.out.println("꼴등 : " + minName + " || 점수 : "+min);
	}
}
