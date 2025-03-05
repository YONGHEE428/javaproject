package day0305;

public class Ex11ClassNotFound {

	public static void main(String[] args) {
		
		try {
			Class cla = Class.forName("java.lang.String2");
			System.out.println("클래스를 찾았습니다.");
		}catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("클래스를 찾을 수 없습니다.");
		}finally {
			//예외발생여부 관계없이 수행할 문장
			//혹은 자원을 사용했다면 반듯이 여기서 반납
			System.out.println("아몰랑 실행해");
		}
		
	}
}
