package day0305;

abstract class AbstoAnnoy{
	
	abstract public void order();
	abstract public void bedal();
	
}

class Abst{
	
	AbstoAnnoy abst = new AbstoAnnoy() {
		
		@Override
		public void order() {
			System.out.println("주문을 합니다");
		}
		
		@Override
		public void bedal() {
			System.out.println("배달을 합니다");
		}
	};
}

public class Ex7Annony {

	public static void main(String[] args) {
		
		Abst ab = new Abst();
		ab.abst.order();
		ab.abst.bedal();
	}
}
