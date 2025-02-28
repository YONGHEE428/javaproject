package day0227;

class Mycar{
	
	private String carName;
	private int carPrice;
	private String carColor;
	
	
	//setter
	public void setName(String name) {
		carName = name;
	}
	public void setPrice(int price) {
		carPrice = price;
	}
	public void setColor(String color) {
		carColor = color;
	}
	
	//getter
	public String getName() {
		return carName;
	}
	public int getPrice() {
		return carPrice;
	}
	public String getColor() {
		return carColor;
	}

	//출력용 메서드
	public void writeCarInfo() {
		System.out.println("자동차명 " + this.carName);
		System.out.println("자동차가격 " + carPrice);
		System.out.println("자동차색상 " + carColor);
	}
}
public class Ex9ObjectTest {

	public static void main(String[] args) {
	
		System.out.println("[나의 자동차 정보");
		Mycar car = new Mycar();
		
		car.setName("그렌저");
		car.setPrice(45000000);
		car.setColor("블랙");
		
		//getter메서드 읽어오기
		System.out.println(car.getName());
		System.out.println(car.getPrice());
		System.out.println(car.getColor());
		System.out.println("========================");
		
		car.setName("그렌저");
		car.setPrice(45000000);
		car.setColor("블랙");
		
		//setter메서드로 수정
		System.out.println("[나의 자동차 정보 수정]");
		car.setName("아우디");
		car.setPrice(65000000);
		car.setColor("화이트");
		
		//출력 메서드
		car.writeCarInfo();
	}
}
