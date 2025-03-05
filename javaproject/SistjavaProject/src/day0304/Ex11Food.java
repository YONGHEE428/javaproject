package day0304;

//인터페이스를 구현하는 클래스
//class가 class를 extends
//class가 interface를 implements

public class Ex11Food implements Ex11FoodShop {
	
	
	
	@Override
	public void order() {
		System.out.println(SHOPNAME);
		System.out.println("음식을 주문합니다.");
		
	}
	
	@Override
	public void bedal() {
		System.out.println("주문한 음식을 배달합니다.");
		
	}
	

}
