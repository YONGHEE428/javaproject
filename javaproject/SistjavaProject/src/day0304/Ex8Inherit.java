package day0304;
//super
class Work{

	public void process() {
		System.out.println("아무 작업도 하지 않는다.");
	}
}
//sub1
class Food extends Work{
	@Override
	public void process() {
		super.process();
		System.out.println("음식을 만든다");
	}
}
//sub2
class Clean extends Work{
	@Override
	public void process() {
		super.process();
		System.out.println("청소를 한다.");
	}
}
public class Ex8Inherit {

	public static void main(String[] args) {
		//다형성이란 하나의 변수로 자식중 누가생성되었느냔에 따라 그 기능이 달라지는데 이를 다향성이라함
		Work work;
		work = new Food();
		work.process();
		
		work = new Clean();
		work.process();
	}
}
