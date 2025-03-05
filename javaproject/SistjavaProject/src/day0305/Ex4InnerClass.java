package day0305;

class OuterObj{
	
	
	
	class InnerObj{
	
		public void write() {
			System.out.println("내부클래스의 메서드");
		}
	}
	public void Show() {
		System.out.println("외부클래스의 메서드");
		System.out.println("외부에서 내부클래스의 메서드 호출");
		InnerObj in = new InnerObj();
		in.write();
	}
	
}
////////////////////////////////
public class Ex4InnerClass {

	public static void main(String[] args) {
		
		OuterObj out = new OuterObj();
		out.Show();
	}
}
