package day0219;

public class OperTest_05 {

	public static void main(String[] args) {
		//비교(관계)연산자 : >, >=, < , <=, ==, !=
		//논리연사자 : &&(and), ||(or), !(not)
		
		int a=5, b=7, c=5;
		
		/*if (a <= b) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		*/
		
		System.out.println(a>b);
		System.out.println(a>=b);
		System.out.println(a<b);
		System.out.println(a<=b);
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(a!=b);
		System.out.println(a<b && b>c);
		System.out.println(a>b || b>c);
		System.out.println(a<b && b<c);
		
		boolean b1 = false;
		
		System.out.println("a = " + b1);
		System.out.println("b = " + !b1);
		
		boolean b2 = 5>3;
		System.out.println("a = " + b2);
		System.out.println("b = " + !b2);
		
	}
}
