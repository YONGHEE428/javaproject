package day0226;

public class ArrayDacha_04 {

	public static void main(String[] args) {
		// 다차원 배열 선언과 동시에 초기화
		
		//int [][] arr = {{22,33},{44,55,66},{77,88,99,100}};
		int [][] arr = {
				{22,33},
				{44,55,66},
				{77,88,99,100}
				};
		
		System.out.println("총 행 개수: "+ arr.length);
		System.out.println();
		for(int i = 0; i < arr.length; i++)
			System.out.println(i+"행의 개수: "+arr[i].length);
		System.out.println();
		
		for(int i = 0; i<arr.length; i++)
		{
			for(int j = 0; j < arr[i].length; j++)
				//System.out.print(arr[i][j] + " ");
				System.out.printf("[%d][%d] = %d  ",i,j,arr[i][j]);
			System.out.println();
		}
		System.out.println();
		//for each 출략
		for(int [] a :arr) {
			for(int n :a) {
				System.out.print(n + "\t");
			}
			System.out.println();
		}
	}
}
