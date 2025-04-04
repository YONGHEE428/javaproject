package day0226;

public class Ex8object {

	String name; // 인스턴스 멤버변수..인스턴수 별수로 호출가능.. 객체 생성 후 각각 다른값 가질 수 있다.
	
	static final String MESSAGE = "Happy Day";
	// static 은 주로 상수선언할때 인스턴스 변수없이 클래스명으로 접근가능
	public static void main(String[] args) {
		
		System.out.println("static 멤버변수는 new로 생성없이 호출가능하다");
		System.out.println(Ex8object.MESSAGE); //클래스명.변수명으로 호출가능
		System.out.println(MESSAGE); // 같은 클래스내에서는 클래스명 생략 가능
		
		//MESSAGE 초기값 재지정
		//MESSAGE = "오늘 따듯하다"; // final이라서 값변경 안됌
		
		Ex8object ab = new Ex8object();
		Ex8object cd = new Ex8object();
		Ex8object ef = new Ex8object();
		
		ab.name = "박용희";
		cd.name = "조태민";
		ef.name = "나나나";
		
		System.out.println(ab.name);
		System.out.println(cd.name);
		System.out.println(ef.name);
		
	}
}
