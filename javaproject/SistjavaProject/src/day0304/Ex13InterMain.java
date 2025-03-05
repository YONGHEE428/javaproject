package day0304;

interface GameA{
	
	public void play();

}
interface GameB{

	public void stop();
	
	
}
class MyGame implements GameA, GameB{
	
	@Override
	public void play() {
		System.out.println("게임을 시작합니다");
	}
	
	@Override
	public void stop() {
		System.out.println("게임을 중지합니다.");
	}
}
public class Ex13InterMain {

	public static void main(String[] args) {
	
		System.out.println("1. 일반 객체 생성 방법");
		MyGame mg = new MyGame();
		mg.play();
		mg.stop();
		
		System.out.println("2. 다형성 객체 생성 방법");
		GameA game = new MyGame();
		game.play();
		
		GameB game1 = new MyGame();
		game1.stop();
	}
}
