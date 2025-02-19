package day0219;

public class OperTest_06 {

	public static void main(String[] args) {
		// 대입연산자 +=, -=, *= , /=
		
		int a,b,c,d,e;
		
		a=b=c=d=e=10;
		
		a += 3;
		b -= 7;
		c *= 2;
		d /= 5;
		e %= 3;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
	}
}
