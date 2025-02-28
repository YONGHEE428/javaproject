package day0227;

class Setdate {
	private int year;
	private int month;
	private int day;
	
	public Setdate (int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public int Getyear() {
		return year;
	}
	public int Getmonth() {
		return month;
	}
	public int Getday() {
		return day;
	}
}
public class Ex6ObjectTest {
	public static void main(String[] args) {
		//인자 3개를 가진 명시적생성자를 이용해서 객체 생성
		Setdate my = new Setdate(1988,10,10);
		
		System.out.println("태어난 년도:" + my.Getyear() + " | 달:" + my.Getmonth() + " | 일:" + my.Getday());
		
	}
}
