package day0307;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import day0228.ex8MethodTest;

public class Ex7BoardList {
	//클래스형으로 지정했으므로 데이처를 꺼내고 받을때고 클래스
	List<Ex7Board> list = new Vector<Ex7Board>();
	
	public void inputdata(	) {
		Scanner sc = new Scanner(System.in);
		String writer, subject,content;
		
		System.out.println("작성자명");
		writer = sc.nextLine();
		System.out.println("글제목");
		subject = sc.nextLine();
		System.out.println("글내용");
		content = sc.nextLine();
		
		Ex7Board data = new Ex7Board("홍길동", "별이 빛는밤" +"히이", content);
		
		
		
	}
	
	private void Ex7Board() {
	}

	public static void main(String[] args) {
		
		
	}
}
