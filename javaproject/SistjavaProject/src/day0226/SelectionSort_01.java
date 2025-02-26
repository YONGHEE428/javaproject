package day0226;

public class SelectionSort_01 {

	public static void main(String[] args) {
		// 그냥 추력하고 오른차순 정렬해서 출력
		
		int [] data = {10,2,9,6,5,8,7,1,3,4};
		
		System.out.println("일반 출력");
		
		for (int n : data)
			System.out.print(n + " ");
		System.out.println();
		
		System.out.println("=====================\n오름차순 출력");
		
		for(int i = 0; i < data.length-1; i++){
			for (int j = i+1; j < data.length; j++){
				if ( data[i]>data[j]){
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		for (int n : data)
			System.out.print(n + " ");
		
	}
}
