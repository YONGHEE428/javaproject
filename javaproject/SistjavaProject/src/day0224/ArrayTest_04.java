package day0224;

import java.util.Random;

public class ArrayTest_04 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		int [] arr, arr2;
		arr = new int[100]; // 메모리 할당
		
		for (int i =0; i < 100; i++)
		{
			arr[i] = rand.nextInt(100)+1;
		}
		
		/*for (int j =0; j < arr.length; j++)
			System.out.println(arr[j]);

		System.out.println("=============");
		
		for (int a : arr)
			System.out.println(arr[a]);*/
		
		System.out.println(arr.length);

	}
}
