package day0305;

import java.text.NumberFormat;
import java.util.Scanner;

class Company{
	
	private String staff,position; //직원명 , 직급
	private int famSu;
	
	//디폴트 생성자
	public void Company() {
		
	}
	//사원명, 직급, 가족수를 인자로 받는 생성자
	public void Company(String staff, String position, int famSu) {
		this.staff = staff;
		this.position = position;
		this.famSu = famSu;
	}
	//각각의 setters & getter
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getFamSu() {
		return famSu;
	}
	public void setFamSu(int famSu) {
		this.famSu = famSu;
	}
	
	//직급에 따라 기본급 : 부장 -> 450 과장 -> 350 대리 -> 280 사원 -> 220 
	public int getGibonPay() {
		switch(position){
		case "부장" :
			return 450;
		case "과장" :
			return 350;
		case "대리" :
			return 280;
		case "사원" :
			return 220;
		default:
			return 0;
		}
	}
	//직급에 따라 수당 : 부장,과장 ==>100	대리,사원 ==> 70	
	public int getSudangPay() {
		if (position.equals("부장") || position.equals("과장"))
			return 100;
		else if (position.equals("대리") || position.equals("사원"))
			return 70;
		else
			return 0;
	}
	//가족수당 : 5인이상  = 30만원 2인이상 10만원 나머지 0원
	public int GetFamSudang() {
		if (famSu >=5)
			return 30;
		else if(famSu>=2)
			return 10;
		else 
			return 0;
	}
	
	//세금 : 기본급의 5%반환받아서 세금
	public double getTax() {
		return (double) getGibonPay() * 0.05;
	}
	//실수령액 : 기본급+수당+가족수당-세금 
	public double getNetPay() {
		return getGibonPay() + GetFamSudang() + getSudangPay() - getTax();
	}
}


public class QuizClass {

	//사원명	직급	기본급	수당	가족수당	세금	실수령액
	public static void showTitle() {
		System.out.println("사원명\t직급\t기본급\t수당\t가족수당\t세금\t실수령액");
		System.out.println("=".repeat(50));
	}
	//한개의 사원데이타 출력
	public static void wirteSawon(Company [] cm) {
		QuizClass.showTitle();
		NumberFormat nf = NumberFormat.getInstance();
		for(Company c : cm)
			System.out.println(c.getStaff() + "\t" + c.getPosition() + "\t" + nf.format(c.getGibonPay()) + "만원\t" + nf.format(c.getSudangPay()) + "만원\t" + nf.format(c.GetFamSudang()) +
								"만원\t" + nf.format(c.getTax()) + "만원\t" + nf.format(c.getNetPay()) + "만원");
	}
	
	public static void main(String[] args) {
		//인원수를 입력 후 인원수만큼 배열 메모리에 할당
		
		Scanner sc = new Scanner(System.in);
		int sawon = 0;
		
		System.out.print("등록할 인원 수를 입력해주세요: ");
		sawon = Integer.parseInt(sc.nextLine());
		Company [] cm = new Company[sawon];
		for(int i = 0; i < sawon; i++)
		{
			cm[i] = new Company();
			System.out.print((i+1)+"번째 사원 이름을 입력해주세요: ");
			cm[i].setStaff(sc.nextLine());
			System.out.print(cm[i].getStaff() + "님의 직급을 입력해주세요: ");
			cm[i].setPosition(sc.nextLine());
			System.out.print(cm[i].getStaff() + "님의 가족수를 입력해주세요 : ");
			cm[i].setFamSu(Integer.parseInt(sc.nextLine()));
			System.out.println("-".repeat(50));
		}
		System.out.println("\t\t*****이달의 월급*****");
		QuizClass.wirteSawon(cm);
		
		
	}
}
