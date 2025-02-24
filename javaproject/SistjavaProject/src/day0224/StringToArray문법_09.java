package day0224;

public class StringToArray문법_09 {

	public static void main(String[] args) {
		// 문자열을 분리하는 메서드 split
		
		
		String menu = "피자,파스타,햄버거,쌀국수,짜장면,비빔밥";
		
		System.out.println(menu);
		System.out.println("menu를 컴마로 분리해서 출력");
		String [] menuarr = menu.split(",");
		System.out.println("분리된 메뉴 갯수: "+menuarr.length);
		
		//출력
		
		for(int i=0; i<menuarr.length; i++)
			System.out.println("메뉴"+(i+1)+": "+menuarr[i]);
		
		System.out.println("==========================");
		
		for(String s : menuarr)
			System.out.print(s+" ");
		
	}
}
