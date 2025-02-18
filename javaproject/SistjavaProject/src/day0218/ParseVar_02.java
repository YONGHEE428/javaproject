package day0218;

public class ParseVar_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "6"; 
		String b = "2";
		
		System.out.println("두수 더하기 : " + (a+b)); 
		System.out.println("두수 더하기 : " + (Integer.parseInt(a) + Integer.parseInt(b)));
		
		int c = Integer.parseInt(a); 
		int d = Integer.parseInt(b); 
		
		System.out.println("두수 더하기 : " + (c+d));
		System.out.println("두수 빼기 : " + (c-d));
		System.out.println("두수 곱하기 : " + (c*d));
		System.out.println("두수 나누기 : " + (c/d));
	}

}
