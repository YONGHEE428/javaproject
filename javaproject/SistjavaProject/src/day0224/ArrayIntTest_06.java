package day0224;

public class ArrayIntTest_06 {

	public static void main(String[] args) {
		// 배열선언하면서 초기값들을 저장할 수 있다
		
		int [] arr = {10,23,4,7,123,99};
		
		System.out.println("arr의 갯수 : " + arr.length + "개");
		
		for ( int i =0; i < arr.length; i++)
		{
			System.out.println((i+1) + "번째 배열:" + arr[i]);
		}
		System.out.println("======================");
		for (int a : arr)
			System.out.print(a + " ");
	}
}
