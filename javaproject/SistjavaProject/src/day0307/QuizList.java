package day0307;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

class Myshop{
	
	private String sangName;
	private int su;
	private int price;
	
	public Myshop() {
		// TODO Auto-generated constructor stub
	}
	
	public Myshop(String sagName, int su, int price) {
		this.sangName = sangName;
		this.price =price;
		this.su = su;
	}
	public String getSangName() {
		return sangName;
	}
	public void setSangName(String sangName) {
		this.sangName = sangName;
	}
	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
////////////////////////////////////////////////////
public class QuizList {

	List<Myshop> list = new Vector<Myshop>();
	
	public void jego() {
		System.out.println("***재고현황***");
		System.out.println("-".repeat(30));
		System.out.println("번호\t상품명\t상품가격\t수량\t총액");
		
		
		for(int i=0; i<list.size();i++)
		{
			Myshop s = list.get(i);
			int total = s.getPrice() * s.getSu();
			System.out.println((i+1) +"\t"+ s.getSangName() +"\t"+ s.getPrice() +"\t"+ s.getSu()+"\t"+total);
		}
	}
	
	public void ipgo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("상풍명 : ");
		String sang = sc.nextLine();
		System.out.print("가격 : ");
		int price = Integer.parseInt(sc.nextLine());
		System.out.print("수량 : ");
		int su = Integer.parseInt(sc.nextLine());
		
		Myshop my = new Myshop();
		my.setSangName(sang);
		my.setPrice(price);
		my.setSu(su);
		
		list.add(my);
		
	}
	public static void main(String[] args) {
		QuizList qu = new QuizList();
		Scanner sc = new Scanner(System.in);
		int n;
		
		while(true)
		{
			System.out.println("1.상품입고 2.재고현황 3.종료");
			n = Integer.parseInt(sc.nextLine());
			
			if(n == 1)
				qu.ipgo();
			else if (n == 2)
				qu.jego();
			else if(n == 3) {
				System.out.println("시스템을 종료합니다.");
				break;	
				}
		}
}
}
