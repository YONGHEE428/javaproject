package day0227;

class Orange{
	
	public Orange() {
		//만들지 않아도 자동존재
		System.out.println("디폴트 생성자 호출");
	}
}
/////////////////////////////////////////////
class Apple{
	public Apple(String str) {
		System.out.println("생성자 호출: " + str + "인자가 존재함");
	}
}
/////////////////////////////////////////////
class Banana{
	public Banana() {
		System.out.println("바나나 디폴트 생성자 호출");
	}
	public Banana(String str) {
		System.out.println("바나나 문자열 생성자 호출: " + str);
	}
	public Banana(int num) {
		this(); // 디폴트 생성자를 다른생성자에서 호출// 반드시 첫줄
		System.out.println("바나나 숫자 생성자 호출: "+ num);
	}
}
////////////////////////////////////////////
public class Ex4ConstTest {

	public static void main(String[] args) {
		//생성자는 객체생성시 자동호출되는 메서드
		//메소드와 차이점 :  클래스명과 같고 리턴형이 존재하지 않는다
		// 오버로딩이 가능하다. (단 인자는 달라야함) (Banana)
		Orange or = new Orange();
		Apple ap = new Apple("사과");
		//Apple ap2 = new Apple("사과2");
		
		Banana ba = new Banana();
		Banana ba2 = new Banana("오늘은 즐거운날");
		Banana ba3 = new Banana(26);
		
	}
}
