package day0227;

class Const{
	
	int num; // 0
	private int num2; // 
	// 디폴트 생성자는 보이지않지만 이미존재한다.
	public Const() {
		this.num = 10;
	}
	//인자있는 생성자가 필요하다면 반드시 생성자를 만든다
	public Const(int num) {
		this.num = num;
	}
	//일반메서드
	public int Const() {
		num = 50;
		return num;
	}
	//setter , getter 메서드 만들기
	//setter메서드
	public void setNum (int number) {
		num2 = number;
	}
	//getter매서드
	public int getNum () {
		return num2;
	}
}
//////////////////////////////////////////////////
public class Ex2ConstTest {

	public static void main(String[] args) {
	
		Const no1 = new Const(); // 디폴트 생성자
		Const no2 = new Const(20); // 인자있는 생성자
		Const no3 = new Const(); // setter / getter 메서드 // 객체 생성
		System.out.println("디폴트 생성자\n"+ no1.num);
		System.out.println("인자있는 생성자\n" + no2.num);
		
		//메서드 출력
		System.out.println(no3.Const());
		
		//setter getter메서드
		no3.setNum(100); // 설정
		System.out.println("setter / getter 메서드 \n" + no3.getNum()); // 호출 및 출력
	}
}
