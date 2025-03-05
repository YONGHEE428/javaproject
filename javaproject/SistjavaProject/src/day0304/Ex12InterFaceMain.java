package day0304;

interface InterA{
	
	public void play();
	public void write();
	
}

interface InterB{
	
	public void draw();
}
//2개의 인터페이스를 구현하는 클래스.. 인터페이스는 다중 구현 가능 하나의 클래스에 여러 인터페이스  

class InterImpl implements InterA,InterB{
	
	@Override
	public void play() {
		System.out.println("게임하기");
	}
	
	@Override
	public void write() {
		System.out.println("그림그리기");
	}
	@Override
	public void draw() {
		System.out.println("공부하기");
	}
}

/////////////////////////////////////////////////////
public class Ex12InterFaceMain {

	public static void main(String[] args) {
		//일반 객체생성으로 출력
		InterImpl imp1 = new InterImpl();
		
		imp1.draw();
		imp1.play();
		imp1.write();
		
		System.out.println("---------------------------------------");
		
		//다향성으로 메서드 출력
		InterA inA = new InterImpl();
		inA.play();
		inA.write();
		
		System.out.println("----------------------------------------");
		
		InterB inB = new InterImpl();
		inB.draw();
		
	}
}
