package day0218;

public class PrintfTest_04 {
	
	public static void main(String[] args) {
		// 문자열을 구성해서 출력하는 printf
		// 문자열내에 따라오는 데이터를 순서대로 배치
		// %d = 10진수정수 , %f :10진수 실수, %s : 문자열, %c = 문자
		
		int a = 10, b = 20;
		int c = a+b;
		
		System.out.println(a + "+" + b + "=" + (a+b) + "\n");
		
		
		System.out.printf("%d + %d = %d\n\n", 1, 2, 3);
		
		String name = "김사랑";
		int age =25;
		
		System.out.printf("안녕하세요 제 이름은 %s 입니다.\n제 나이는 %d세 입니다.", name, age);
		
	}
}
