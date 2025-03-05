package day0304;

import java.util.Scanner;

class Sawon{
	private String Sname;
	private String Sdept;
	private int Spay;
	
	public void WriteSawon(String name, String dept, int pay) {
		Sname = name;
		Sdept = dept;
		Spay = pay;
	}
	public int getBonus() {
		if (Sdept.equals("개발부")) {
			return 1000000;
		}
		else { 
			return 500000;
		}
	}
	public void Write() {
		int tot = Spay + getBonus();
		System.out.println("이름\t부서\t기본급\t\t보너스\t\t총월급");
		System.out.println(Sname + "\t" + Sdept + "\t" + Spay + "\t\t" + getBonus() + "\t\t" + tot);
	}
}

public class QuizSawon {

	public static void main(String[] args) {
		
	
		
		Scanner sc = new Scanner(System.in);
		
		Sawon sa = new Sawon();
		
	
		System.out.println("이름과 부서 기본급을 입력하시오 ");
		sa.WriteSawon(sc.nextLine(), sc.nextLine(), Integer.parseInt(sc.nextLine()));
		
		sa.Write();
		
		System.out.println("-----------------------------------------------------------");
		System.out.print("이름을 입력하시오: ");
		String name = sc.nextLine();
		System.out.print("부서를 입력하시오: ");
		String dept = sc.nextLine();
		System.out.print("기본급을 입력하시오: ");
		int pay = Integer.parseInt(sc.nextLine());
		
		Sawon sa2 = new Sawon();
		sa2.WriteSawon(name, dept, pay);
		sa2.Write();
		
	}

	
}
