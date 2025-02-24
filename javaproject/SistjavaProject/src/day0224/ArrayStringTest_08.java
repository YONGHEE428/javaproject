package day0224;

public class ArrayStringTest_08 {

	public static void main(String[] args) {
		// String 배열선언과 동시에 초기값
		
		String [] str1 = {"피자", "파스타", "햄버거", "쌀국수", "짜장면", "비빔밥"};
		String [] str2 = new String[5];
		
		//str2에 문자열 초기화
		str2[0] = "레드";
		str2[2] = "주황";
		str2[4] = "초록";
		
		
		for(int i=0; i<6; i++)
		{
			System.out.println("str1출력_메뉴"+(i+1)+": "+str1[i]);
		}
		
		for(int i=0; i<5; i++)	
			System.out.println(str2[i]);
		
		System.err.println("===========================");
		
		for(String a : str1)
			System.out.println(a);
		System.out.println("==========================");
		
		for (int i=0; i<5; i++)
			System.out.println("str1출력_Color"+(i+1)+": " +str2[i] );
		
		System.out.println("==========================");
		for(String s : str2)
			System.out.print(s+" ");
	}
}
