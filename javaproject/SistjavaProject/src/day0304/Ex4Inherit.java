package day0304;

class shop{
	
	private String sangpum;
	private int su;
	
	//디폴트 생성자
	public shop() {
		sangpum = "딸기";
		su = 5;
	}
	//명시적 생성자
	public shop (String name, int su) {
		this.sangpum = name;
		this.su = su;
	}
	public void writeShop() {
		System.out.println("상품명 : " + sangpum);
		System.out.println("수량: "+su);
	}
	
}
//////////////////////////Shop을 상속받는다,생성자 2개와 메소드 하나/////////////////////
class Myget extends shop{
	private int price;
	
	//디폴트 생성자
	public Myget() {
	}
	//명시적 생성자
	public Myget(String name,int su,int price) {
		super(name,su);
		this.price = price;
	}
	@Override
	public void writeShop() {
		super.writeShop();
		System.out.println("가격: "+price + "원");
	}
	
}

//////////////////////////////////////////////
public class Ex4Inherit {

	public static void main(String[] args) {
		
		Myget mg = new Myget();
		mg.writeShop();
		
		Myget mg2 = new Myget("쵸코파이", 15, 500);
		mg2.writeShop();
	}
}
