package day0305;
//super
class Car{
	
	private String carName;
	private String carColor;
	
	public void Car(String carName, String carColor) {
		this.carName = carName;
		this.carColor = carColor;
	}
	

	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public void writeCar () {
		System.out.println("내차는 "+ carName+"이고 색상은 "+carColor+" 입니다.");
	}
}

//sub
class MyCar extends Car{
	private int carPrice;
	
	public MyCar(String carName, String carColor, int carPrice) {
		super.Car(carName, carColor);
		this.carPrice = carPrice;
	}
	public MyCar() {
		
	}
	public int getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	
	@Override
	public void writeCar() {
		super.writeCar();
		System.out.println("가격은 "+carPrice+"원 입니다.");
	}
}

public class Ex1Extends {
	public static void main(String[] args) {
		
		MyCar car2 = new MyCar("아우디", "검은색", 54000000);
		car2.writeCar();
		System.out.println("----------------------------------");
		

	
		MyCar car = new MyCar();
		
		car.writeCar();
		System.out.println("-------------------------------");
		car.setCarName("아반떼");
		car.setCarColor("파란색");
		car.setCarPrice(15000000);
		car.writeCar();
		
		
	}
}
