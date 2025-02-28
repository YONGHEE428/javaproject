package day0227;

import java.util.Calendar;

class QuizShop{
	
	static int cnt = 0;
	static String shopName;
	private String name;
	private int count;
	private int price;
	
	//기본 생성자
	public QuizShop() {
		
	}
	//생성자
	public QuizShop(String name, int count, int price) {
		this.name = name;
		this.count = count;
		this.price = price;
	}
	
	//setter 메서드
	public void setName(String name) {
		this.name = name;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	// set()메서드
	public void set(String name, int count, int price) {
		this.name = name;
		this.count = count;
		this.price = price;
		
	}
	//getter 메서드
	public String getName() {
		return name;
	}
	public int getCount() {
		return count;
	}
	public int getPrice() {
		return price;
	}
	
	//get()메서드
	public String get() {
		cnt++;
		String s = "입고물품" + cnt +"\n========================\n상점명: " + shopName + "\n상품명: " + name + "\n수량: " + count + "개\n단가: " + price + "원\n";
			return s;
	}
	
}
public class QuizShopTest {

	public static void main(String[] args) {
		
		QuizShop.shopName = "이마트 강동지점"; //정적 변수 선언
		Calendar cal = Calendar.getInstance();
		int a = cal.get(Calendar.YEAR);
		int b = cal.get(Calendar.MONTH)+1;
		int c = cal.get(Calendar.DATE);
		
		System.out.println("[오늘의 입고상품(" + a + "/" + b + "/" + c + ")]\n");
		
		//생성자
		QuizShop c1 = new QuizShop("땅콩버터", 100, 11000); // 객체 생성 및 설정
		System.out.println(c1.get()); // 출력
		
		//set()메서드
		QuizShop c2 = new QuizShop(); // 객체 생성
		c2.set("사과", 200, 5000); // 객체 설정
		System.out.println(c2.get()); // 출력
	
		//setter / get() 메서드     
		QuizShop c3 = new QuizShop(); // 객체 생성
		c3.setName("바나나"); // 객체 설정
		c3.setCount(150); // 객체 설정
		c3.setPrice(7500); // 객체 설정
		System.out.println(c3.get()); // 같은 호출메서드를 사용하여 cnt값을 증가시켜야함으로 getter메서드사용 불가 //출력
		
		
	}
	
}
