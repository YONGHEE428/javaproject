package day0226;

import java.util.Scanner;

public class ArrayScanSwitch_02 {

	public static void main(String[] args) {
		//인원수를 입력후 인원 수 만큼 자바,오라를 두 점수 입력\
		//총점, 평균,순위,등급
		
		Scanner sc = new Scanner(System.in);
		
		int inwon;
		int [] java, oracle, sum,rank;
		String [] grade, name;
		double[] avg;
		
		
		System.out.print("성적을 입력할 인원 수는 ?");
		inwon = Integer.parseInt(sc.nextLine());
		System.out.println("-----------------------");
		
		java = new int[inwon];
		oracle = new int [inwon];
		sum = new int [inwon];
		rank = new int [inwon];
		
		name = new String[inwon];
		grade = new String[inwon];
		
		avg = new double[inwon];
		
		for(int i = 0; i < inwon; i++) {
			System.out.print((i+1) + "번째 이름 입력 ");
			name[i] = sc.nextLine();
			System.out.print("자바와 오라클 점수 입력 : ");
			java[i] = Integer.parseInt(sc.nextLine());
			oracle[i] = Integer.parseInt(sc.nextLine());
			
			sum[i] = java[i] + oracle[i];
			avg[i] = sum[i] / 2.0;
		}
			//등수 구하기
		for (int i = 0; i < inwon; i++) {
			rank[i]=1;
			for (int j = 0; j < inwon; j++) {
				if(sum[i]< sum[j]) {
					rank[i]++;
				}
			}
		}
		//등급 
		for(int i = 0; i < inwon; i++) {
			/*switch((int) avg[i]/10) {
			case 10 : 
				
			case 9 :
				grade[i] = "전액장학생";
				break;
			case 8 : 
				grade[i] = "반액장학생";
				break;
			default : 
				grade[i] = "장학 해당 없음";
				break;
			}*/
		
		
		//jdk12에서 추가된 문법
		grade[i] = switch((int)avg[i]/10) {
		case 10, 9-> "전액 장학생";
		case 8 -> "반액장학생";
		default->"장학금 해당없음";
		};
		
		}	
		
		System.out.println("번호\t이름\t자바\t오라클\t총점\t평균\t등수\t등급");
		System.out.println("====================================================================");
		for(int i = 0; i<inwon;i++) {
			System.out.printf("%d번\t%s\t%d점\t%d점\t%d점\t%.2f\t%d등\t%s\n",i+1,name[i],java[i],oracle[i],sum[i],avg[i],rank[i],grade[i]);
		}
		
			
	}
}
