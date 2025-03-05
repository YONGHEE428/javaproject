package day0305;

abstract class Game{
	abstract void play();
	abstract void stop();
}
////////////////////////////////////

class YongHee extends Game{

	@Override
	void play() {
		System.out.println("용희 님이 게임을 시작합니다.");
	}

	@Override
	void stop() {
		System.out.println("용희 님이 게임을 중단합니다");
	}
	
}
class JooHee extends Game{


	@Override
	void play() {
		System.out.println("주희 님이 게임을 시작합니다.");
	}

	@Override
	void stop() {
		System.out.println("주희 님이 게임을 중단합니다");
	}
	
}
class HeaJee extends Game{

	@Override
	void play() {
		System.out.println("혜지 님이 게임을 시작합니다.");
	}

	@Override
	void stop() {
		System.out.println("혜지 님이 게임을 중단합니다");
	}
}

public class Ex3Abst {

	public static void main(String[] args) {
		
		Game [] gm = new Game[3] ;
		gm[0] = new YongHee();
		gm[1] = new JooHee();
		gm[2] = new HeaJee();
		
		System.out.println("----------------------------");
		
		for (int i = 0; i < 3; i ++) {
			gm[i].play();
		}
		System.out.println("============================");
		for (int i = 2; i >=0; i --) {
			gm[i].stop();
		}
	}
}
