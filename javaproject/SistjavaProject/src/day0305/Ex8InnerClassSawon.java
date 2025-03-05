package day0305;

import java.util.Scanner;


class Sawon{
	
	private String Sname;
	private String Sdept;
	private int Spay, Timesu, Familysu;
	
	class InputInner{
		
		public void inputdata() {
			Scanner sc = new Scanner(System.in);
			System.out.print("사원 이름을 입력하시오 ");
			Sname = sc.nextLine();
			System.out.print("부서를 입력하시오 ");
			Sdept = sc.nextLine();
			System.out.print("기본급을 입력하시오: ");
			Spay = Integer.parseInt(sc.nextLine());
			System.out.print("가족수를 입력하시오");
			Familysu = Integer.parseInt(sc.nextLine());
			System.out.print("초과근무 시간을 입력하시오 ");
			Timesu = Integer.parseInt(sc.nextLine());
		}
	}
	class SudanInner{
		public int GetBouns() {
			if(Sdept.equals("개발부"))
				return 1000000;
			else
				return 500000;
		}
		public int GetTimeSudang() {
			return Timesu *20000;
		}
		public int GetFamilySudang() {
			return Familysu * 50000;
		}
		public int TotalSudang() {
			return GetBouns() + Spay + GetTimeSudang() + GetFamilySudang();
		}
		public void WritePay() {
			System.out.println("이름\t부서\t기본급 \t보너스 \t가족수당 \t시간수당 \t총급여");
			System.out.println(Sname+"\t"+Sdept+"\t"+Spay+"\t"+GetBouns()+"\t"+GetFamilySudang()+"\t"+GetTimeSudang()+"\t"+TotalSudang());
		}
	}
	InputInner in = new InputInner();
	SudanInner su = new SudanInner();
}
public class Ex8InnerClassSawon {

	public static void main(String[] args) {
		Sawon sa = new Sawon();
		sa.in.inputdata();
		sa.su.WritePay();
		System.out.println("---------------------------------------------");
		//외부클래스.내부클래스 변수 = 외부클래스객체선언한 변수.new 내부클래스 = 내부클래스 한개일때
		Sawon.InputInner in2 = sa.new InputInner();
		Sawon.SudanInner su2 = sa.new SudanInner();
		in2.inputdata();
		su2.WritePay();
		System.out.println("---------------------------------------------");
		//외부클래스.내부클래스 변수 = new 외부클래스.new 내부클래스 = 내부 클래스 한개일때
		Sawon.InputInner input = sa.new InputInner();
		Sawon.SudanInner output = sa.new SudanInner();
		input.inputdata();
		output.WritePay();
		
		
	}
}
