package day0218;

import java.util.Scanner;

public class KeyBoardIn_12 {

	public static void main(String[] args) {
		// Scannersms I문장ㄹ이나 숫자를 모두 키보드로 입력받을때 생성
		
		Scanner sc = new Scanner(System.in);
		
		String name, city;
		int age;
		
		System.out.print("이름을 입력해 보세요===> ");
		name = sc.nextLine();
		
		System.out.print("사는 곳을 입력하세요===> ");
		city = sc.nextLine();
		
		System.out.print("나이를 입력하세요===> ");
		age = sc.nextInt();
		
		System.out.println("==========================");
		System.out.println("이름 : " + name);
		System.out.println("사는 곳 : " + city);
		System.out.println("나이 : " + age + "살");
		
	}

}
