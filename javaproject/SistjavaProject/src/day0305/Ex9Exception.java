package day0305;

public class Ex9Exception {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		try {
		int num =5/0; //예외발생 코드 정수 5를 0으로 나눌 순 없다
		}catch (ArithmeticException e) {
			System.out.println("되겠냐?");
			//e.printStackTrace(); //자세한 예외정보 출력
			System.out.println(e.getMessage());
		}
		System.out.println("프로그램 정상 종료");
	}
}
