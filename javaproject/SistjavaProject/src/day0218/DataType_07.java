package day0218;

public class DataType_07 {

	public static void main(String[] args) {
		// 아스키코드 A= 65 a =97
		//묵시적형변환
		
		char a ='A';
		System.out.println(a);
		System.out.println(a+32);
		System.out.println((char)(a+32)); //강제 형변환
		
		System.out.println("Today" + 5+6);
		System.out.println("Today" + (5+6));
		System.out.println('A'+ 3);
		
		
		System.out.printf("%C%C%C%C%C\n",84,79,68,65,89);
		
	}

}
