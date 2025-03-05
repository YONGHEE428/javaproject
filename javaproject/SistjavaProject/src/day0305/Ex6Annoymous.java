package day0305;

abstract class AbstEx{
	
	abstract public void show();
	
}

class OuterEx{
	
	AbstEx ab = new AbstEx() {
		
		@Override
		public void show() {
			System.out.println("수정띠");
		}
	};
}
public class Ex6Annoymous {

	public static void main(String[] args) {
		
		OuterEx ex = new OuterEx();
		ex.ab.show();
	}
}
