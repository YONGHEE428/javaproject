package day0304;

class point{
	
	int x;
	int y;

	//디폴트 생성자
	public point() {
		System.out.println("Super_디폴트 생성자 호출");
	}
	//명시적 생성자
	public point (int x, int y) {
		System.out.println("Super_인자값있는 명시적 생성자호출");
		this.x = x;
		this.y = y;
	}
	
	//메서드
	public void write() {
		System.out.println("x좌표는 = "+x+ " , y좌표는 = "+y);
	}
	
}
////////////////////////point 상속받기,부모의 생성자2개받기
class Subpoint extends point{
	String msg;
	
	public Subpoint() {
		
	}
	public Subpoint(int x, int y, String msg) {
		super(x,y);
		this.msg = msg;
	}
	
	//부모의 메서드 재구현
	@Override
	public void write() {
		super.write();
		System.out.println("오늘의 메세지는 : " + msg);
	}
}
//////////////////////////
public class Ex3SuperSub {
	public static void main(String[] args) {
		Subpoint sub2 = new Subpoint();
		sub2.write();
		System.out.println("----------------------------------");
		Subpoint sub1 = new Subpoint(11,22,"안녕하세용");
		sub1.write();
	}
}
