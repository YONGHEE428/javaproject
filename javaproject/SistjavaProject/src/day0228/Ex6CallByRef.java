package day0228;

class MyBag{
	 String bagname;
	 int bagPrice;
	 String bagColor;
	
}
//////////////////////////////////
public class Ex6CallByRef {

	public static void bagInfoIn(MyBag bag)
	{
		//MyBag멤버 초기화
		bag.bagname = "백팩";
		bag.bagColor = "블랙";
		bag.bagPrice = 65000;
		
	}
	
	//출력 
	public static void bagInfoOut(MyBag bag) {
		System.out.println("가방명 :" +bag.bagname);
		System.out.println("가방가격 :" +bag.bagPrice);
		System.out.println("가방색상 :" +bag.bagColor);
	}
	
	
	
	public static void main(String[] args) {
		//두메서드 다 주소전달이 되므로 메인에 bag변수에 데이타가 들어가고 출력된다
		
		MyBag bag = new MyBag();
		bagInfoIn(bag);
		bagInfoOut(bag);
	}
	
}
