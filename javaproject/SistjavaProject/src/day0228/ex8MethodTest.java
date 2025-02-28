package day0228;

////////////////////////////////////////////////
public class ex8MethodTest {

	public static void hi(int age) {
		System.out.println("안녕");
		System.out.println("저의 나이는 "+age+"입니다.");
	}
	
	public static void main(String[] args) {
		
		System.out.println("프로그램의 시작!!!");
		hi(22);
		hello("손흥민");
		hi(55);
		System.out.println("===========================");
		hello("박용희");
		System.out.println("프로그램의 끝!!!");
		
	}
	
	public static void hello(String str) {
		System.out.println("반갑습니다.");
		System.out.println("저의 이름은 "+str+"입니다.");
	}
}
