package day0226;

public class Ex12InfoTest {

	public static void main(String[] args) {
		
		Ex12Info in1 = new Ex12Info();
		//setter메스더를 이용한 값설정
		// setName이라는 setter메서드 이용해서 초기값 변경
		in1.setName("박용희");
		in1.setAge(26);
		
	
		//getter메서드를 이용한 값얻기
		String name = in1.getName();
		System.out.println(name);
		
		int age = in1.getAge();
		System.out.println(age);
		
	}
}
