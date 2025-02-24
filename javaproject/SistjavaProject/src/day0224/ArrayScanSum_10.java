package day0224;

import java.util.Scanner;

public class ArrayScanSum_10 {

	public static void main(String[] args) {
		/* 1번째 값 : 55
		 * 2번째 값 : 88
		 * 3번째 값 : 78
		 * 4번째 값 : 99
		 * 5번째 값 : 48
		 * 입력값 홧인
		 * 0==> 55
		 * 1 ==> 88
		 * 2 ==> 78
		 * 3 ==> 99
		 * 4 ==> 48
		 * =====================
		 * 총합계 : *** 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int [] data;
		data = new int[5];
		int sum = 0;
		
		for ( int i = 0; i < data.length; i++)
		{
			System.out.print((i+1)+ "번째 값: ");
			data[i] = Integer.parseInt(sc.nextLine());
			sum += data[i];
		}
		for (int j=0; j < data.length; j++)
		{
			System.out.println(j+" ==> " + data[j]);
		}
		System.out.println("=====================");
		System.out.println("총합계 : "+sum);
	}
}
