package day0218;

import java.util.Iterator;

public class VariableTest_01 {

	public static void main(String[] args) {
		
		int a=100;
		int b = 200;
		int c = a + b;
		
		System.out.println(a + "+" + b + "=" + c);
		
		String d = "10";
		String e = "20";
		
		System.out.println(d + " + " + e + " = " + (d+e));
		// String 타입을 int타입으로 변경하려면
		//Integer.paresInt("1") = 문자열 1이 정수 1로 변환
		//Double.parseDouble("12.5") = 문자열 12.5이 실수 12.5로 반환
		
		int f = Integer.parseInt(d) + Integer.parseInt(e);
		
		
		System.out.println(d + " + " + e + " = " + f);
		
	}

}
