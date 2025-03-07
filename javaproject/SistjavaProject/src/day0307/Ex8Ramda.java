package day0307;
//자바에서의 함수형 프로그램인 람다 표현식
//익명 내부 클래스의 또다른 표현식
//단 하나의 추상메서드만 가지고있어야한다

@FunctionalInterface
interface Orange{
	public void write();
	//public void Show();
}
////////////////////////////////////////
public class Ex8Ramda {

	public void abstMethod1() {
		Orange or = new Orange() { 
			
			@Override
			public void write() {
				System.out.println("나는 익명내부 클래스 오렌지");
			}
		};
		or.write();
	}
	public void abstMethod2() {
		Orange or = ()->System.out.println("나는 람다 오렌지");
		or.write();
		
		System.out.println("여러개일 경우");
		Orange or2 = ()->{
			System.out.println("나는 람다 오렌지");
			System.out.println("나도 람다 오렌지당");
		};
		or2.write();
	}
	
	public static void main(String[] args) {
	
		Ex8Ramda ex = new Ex8Ramda();
		ex.abstMethod1();
		System.out.println("-".repeat(50));
		ex.abstMethod2();
	}
}