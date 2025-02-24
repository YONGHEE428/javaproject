package day0224;

public class ExString중요문법_03 {

	public static void main(String[] args) {
		//.trim() = 앞뒤 공백 제거, .lenght() = 글자개수
		
		System.out.println("String 객체에 대한 멤버메서드");
		
		String str1 = "apple";
		String str2 = "Apple";
		String str3 = "Have a Nice Day!!!";
		String str4 = " Happy day ";
		
		System.out.println("str4의 길이 : " + str4.length());
		System.out.println("str4의 공백제거 후 길이 :" + str4.trim().length());
	
		System.out.println("str3의 N의 인덱스값 : " + str3.indexOf("N"));
		
		System.out.println("Nice만 출력 : " + str3.substring(7, 11));
		
		//equals = 문자열 대소문자 비교
		System.out.println("문자열 비교 : " +str1.equals(str2));
		System.out.println("문자열 비교 : "+ str1.equalsIgnoreCase(str2));
		
		//a.comepareTo(b) = a와 b가 같을경우 0, 아닌경우 어떤게 더 큰지 비교 a가 작을경우 -값 클경우 +값(알파벳 차이만큼)
		
		System.out.println(str1.compareTo(str2)); // str1 = a, str4 = b
		
		System.out.println("computer".compareTo("command")); // 같은글자 제외 처음 다른글자들을 비교
		
		System.out.println(str3.replace('a', '*')); // 글자 변환
		System.out.println(str3.replace("Nice", "Good"));
		
		// int => String
		String a =String.valueOf(100); // int 100 을 String 100으로 a에 입력
		String b = String.valueOf(100.3);
		String c = 100+""; // 같은 맥락 c에들어간 100도 String
		System.out.println(b);
		
	}
}
