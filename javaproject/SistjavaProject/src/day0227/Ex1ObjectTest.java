package day0227;

public class Ex1ObjectTest {

	public static void main(String[] args) {
	
		//static은 바로사용가능
		System.out.println(Ex1Object.b); // int의 초기값은 0	
	
		//static int b 선언  ex) 클래스명.스태틱변수명
		Ex1Object.b = 10; // 선언
		System.out.println(Ex1Object.b);
		
		//a생성 ex) 클래스명 인스턴스변수명 = new 클래스명
		Ex1Object c1 = new Ex1Object();
		Ex1Object c2 = new Ex1Object();
		
		System.out.println(c1.a); //초기값
		
		c1.a = 20; // 선언
		c2.a = 40;
		
		System.out.println(c1.a);
		System.out.println(c2.a);
	
	
	}
}
