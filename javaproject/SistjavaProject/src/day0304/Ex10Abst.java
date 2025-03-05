package day0304;

import java.util.Scanner;

abstract class Board {
	
	public abstract void process(); //추상메서드

}

class List extends Board{
	@Override
	public void process() {
		System.out.println("게시판을 출력합니다.");
	}
	
}

class Write extends Board{
	@Override
	public void process() {
		System.out.println("게시판을 입력합니다.");	
	}	
}

class Update extends Board {
	@Override
	public void process() {
		System.out.println("게시판을 수정합니다.");
	}	
}

class Delete extends Board{
	@Override
	public void process() {
		System.out.println("게시판을 삭제합니다.");
	}	
}
/////////////////////
public class Ex10Abst {
	//Board bo = new Board(); 추상클래스는 new로 객체생성안됨
	public static void main(String[] args) {
	
		/*Board bo;
		bo = new List();
		bo.process();
		
		bo = new Write();
		bo.process();
		
		bo = new Update();
		bo.process();
		
		bo = new Delete();
		bo.process();*/
		
		Scanner sc = new Scanner(System.in);
		
		int num; //입력할 숫자
		Board board = null; // 부모로 선언
		
		System.out.println("**** 게시판 관리 ****");
		
		while(true) {
			System.out.println("1.입력 | 2.출력 | 3.수정 | 4.삭제 | 9.종료");
			num=sc.nextInt();
			
			switch(num) {
			case 1 : 
				board = new Write();
				break;
			case 2 :
				board = new List();
				break;
			case 3 :
				board = new Update();
				break;
			case 4 : 
				board = new Delete();
				break;
			default :
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}
			
			board.process(); // 다형성이므로 하나의 변수로 4개의 메소드 호출이 가능해짐
			
		}
		
		
		
	}
		
}
