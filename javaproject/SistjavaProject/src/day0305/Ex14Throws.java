package day0305;

import java.util.Scanner;

class UserException extends Exception{
	
	public UserException(String msg) {
		super(msg); //Exception 클래스 생성자를 통해서 정식메세지로 등록
	}
}
//////////////////////////////
public class Ex14Throws {

	public static void process() throws UserException{
	
		Scanner sc = new Scanner(System.in);
		int age = 0;
		//나이가 20~59가 아니면 UserException강제발생
		System.out.println("나이를 입력하세요");
		age = sc.nextInt();
		
		if(age <20 || age >59) {
			throw new UserException("멤버의 연령은 20~59세 까지 입니다.");
		}else
			System.out.println("당신은 " + age + "세 이므로 멤버로 등록됩니다.");
	}
	
	public static void main(String[] args) {
		try {
			process();
		} catch (UserException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println("*****정상 종료*****");
	}
}
