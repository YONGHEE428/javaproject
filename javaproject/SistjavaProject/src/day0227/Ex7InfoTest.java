package day0227;

class YourInfo{
	String myName;
	static String Message;
}
////////////////////////////////

public class Ex7InfoTest {
		String city;
		int age;

	public static void main(String[] args) {
		YourInfo i = new YourInfo();
		i.myName = "박용희";
		YourInfo.Message = "즐거운 하루 되세요";
		System.out.println("주민정보: " +i.myName);
		System.out.println(YourInfo.Message);
		
		
		Ex7InfoTest c1 = new Ex7InfoTest();
		c1.city = "서울";
		c1.age = 26;
		System.out.println("지역: "+c1.city+"\n나이: "+ c1.age);
	}
}
