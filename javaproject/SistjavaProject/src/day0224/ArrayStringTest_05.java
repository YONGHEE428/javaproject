package day0224;

public class ArrayStringTest_05 {

	public static void main(String[] args) {
		// 문자 배열 선언및 초기화
		
		String [] str;
		str = new String[5]; //5개의 주소값 할당 초기값 지정안해도 null로 초기화
		
		for (int i = 0; i < str.length; i++)
			System.out.println(str[i]);
		
		//초기값 지정
		str[0] = "원주희";
		str[1] = "유혜지";
		str[2] = "조태민";
		str[3] = "박용희";
		str[4] = "김희찬";
		
		for (int i = 0; i < str.length; i ++)
		{
			System.out.println((i+1) + " : " + str[i]);
		}
		//for ~ each
		for (String a : str)
			System.out.println(a);
	}
}
