package day0306;

import java.util.StringTokenizer;

public class Ex3Tokens {

	public static void main(String[] args) {
		
		String strs = "장미,백합,튤립,후리지아,수국,안개꽃";
		
		System.out.println("String의 객체를 split을 이용하여 분리");
		System.out.println("-".repeat(50));
		String [] flowers = strs.split(",");
		System.out.println("총 "+ flowers.length + "개"); 
		//for
		for(String s : flowers) {
			System.out.print(s + " ");
		}
		
		System.out.println("\n"+"-".repeat(50));
		System.out.println("String의 객체를 StringTokenizer을 이용하여 분리");
		StringTokenizer st = new StringTokenizer(strs, ",");
		System.out.println("총토큰수 : " +st.countTokens());
		
		while(st.hasMoreTokens()) { //다음 토큰이 있다면 ture, 없으면 false
			System.out.print(st.nextToken() + " ");
		}
	}
}
