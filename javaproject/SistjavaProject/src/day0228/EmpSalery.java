package day0228;

import java.util.Scanner;

//사원명  기본급  가족수(인당 10 최대 30)  초과시간  가족수당   초과근무수당   총급여     




class Emp {
	
	private String name;
	private int pay;
	private int famSu;
	private int timeSu;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getFamSu() {
		return famSu;
	}
	public void setFamSu(int famSu) {
		this.famSu = famSu;
	}
	public int getTimeSu() {
		return timeSu;
	}
	public void setTimeSu(int timeSu) {
		this.timeSu = timeSu;
	}
	public static void ShowTitle() {
		System.out.println("사원명\t기본급\t가족수\t초과시간\t가족수당\t초과근무수당\t총급여");
	}
	public int getFamSudang() {
		int famsudang = 0;
		if (famSu >= 4) {
			famsudang = 200000;
		}else
			famsudang = famSu * 50000;
		return famsudang;
	}
	public int getTimeSudang() {
		int timesudang = 0;
		if(timeSu >=10) {
			timesudang = 300000;
		}else 
			timesudang = timeSu * 30000;
		return timesudang;
	}
	public int getTotalPay() {
		return pay + getTimeSudang() + getFamSudang();
	}

}
/////////////////////////////////////
///메인에서는 인원을 입력후 해당사원에 대한 이름.기본급 가족수, 오버타임을 입력받아 출력할것
public class EmpSalery {
	
	public static void showEmpSalery(Emp [] t) {
		
		Emp.ShowTitle();
		for(Emp i: t)
		{
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t\t%d\n",i.getName(),i.getPay(),i.getFamSu(),i.getTimeSu(),i.getFamSudang(),i.getTimeSudang(),i.getTotalPay());
		}
	
}
	public static void main(String[] args) {
		
		int inwon;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("인원을 입력하세요: ");
		inwon = Integer.parseInt(sc.nextLine());
		Emp [] t = new Emp[inwon];
		
		for (int i = 0; i < inwon; i++) {
			t[i] = new Emp();
			System.out.print((i+1)+"번 사원의 이름: ");
			t[i].setName(sc.nextLine()); 
			System.out.print((i+1) + "번 사원의 기본급: ");
			t[i].setPay(Integer.parseInt(sc.nextLine()));
			System.out.print((i+1) + "번 사원의 가족수: ");
			t[i].setFamSu(Integer.parseInt(sc.nextLine()));
			System.out.print((i+1) + "번 사원의 초과근무시간: ");
			t[i].setTimeSu(Integer.parseInt(sc.nextLine()));
			System.out.println("--------------------------------");
		}
		
		showEmpSalery(t);
		
		
		
	}
}
