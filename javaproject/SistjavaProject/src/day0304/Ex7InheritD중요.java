package day0304;

//Super
class Color{
	
	public void hello() {
		System.out.println("Hello~~~");
	}
}
//sub1
class Red extends Color{
	
	public void process() {
		System.out.println("나는 빨강색을 좋아해");
	}
}
//sub2
class Yellow extends Color{
	
	public void process() {
		System.out.println("나는 노랑색을 좋아해");
	}
}
//sub3
class Green extends Color{
	
	public void process() {
		System.out.println("나는 초록색을 좋아해");
	}
}
////////////////////////////////////
public class Ex7InheritD중요 {

	public static void main(String[] args) {
		
		System.out.println("1.Red로 선언하고 Red로 생성한경우");
		Red r1 = new Red();
		r1.hello();
		r1.process();
		System.out.println("=============================");
		System.out.println("2.Yellow로 선언하고 Yellow로 생성한경우");
		Yellow ye = new Yellow();
		ye.hello();
		ye.process();
		System.out.println("=============================");
		System.out.println("3.Green로 선언하고 Green로 생성한경우");
		Green gr = new Green();
		gr.hello();
		gr.process();
		System.out.println("=============================");
		
		
		//다향성_부모로 선언학 자식으로 생성하는 경우
		Color col1; //선언
		col1 = new Red();
		
		col1.hello(); // 부모가 가진 메소드 호출도 ok
		//메서드가 오버라이드된 경우 호출 ok
		//부모한텐 없고 자식만 갖고있는 메서드는 호출 안됨
		//col1.process(); 호출 안됨
		
	}
}
