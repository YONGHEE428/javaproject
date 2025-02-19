package day0219;

import java.util.Scanner;

public class ScanIf_11 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String name;
		int java, jsp, spring;
		
		System.out.print("이름 입력 ==>");
		name = sc.nextLine();
		System.out.println("java, jsp, spring 과목점수를 차례로 입력하세요");
		java = sc.nextInt();
		jsp = sc.nextInt();
		spring = sc.nextInt();
		
		int tot = java + jsp + spring;
		double val = tot / 3;
		String x;
		if (val >=80)
			x = "참잘함";
		else if (val >=70)
			x = "노력하세요";
		else 
			x = "불합격";
		
		System.out.println(name+"님의 시험결과");
		System.out.println("총점 : "+ (java + jsp + spring));
		System.out.printf("평균 : %.1f\n", val);
		System.out.println("평가 : " + x);
	}
}
