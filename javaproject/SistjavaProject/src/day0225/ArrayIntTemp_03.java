package day0225;

public class ArrayIntTemp_03 {

	public static void main(String[] args) {
		//정렬을 알기전에 순서 바꾸기가 먼저 연습되야함
		
		int a = 10, b = 20;
		System.out.println("a = " + a + ", b = " +b);
		
		int temp; // 다른변수명이여도 상관 없지만 관례상 구별하기 편하게
		
		temp = a;
		a = b;
		b = temp;
		
		System.out.println("a = " + a + ", b = " +b);
		
		
		// 3개이상은 배열로 테스트
		
		int [] nums = {9,6,3};
		
		for(int n:nums)
			System.out.print(n+ " ");
		
		System.out.println("\n0번과 2번을 교환후 출력");
		
		int temp2 = nums[0];
		nums[0] = nums[2];
		nums[2] = temp2;
		
		for(int n:nums)
			System.out.print(n + "  ");
		System.out.println("");
		System.out.println("==============================");
		// 8개 이상의 배열
		
		int [] nums2 = {1,2,3,4,5,6,7,8};
		
		for(int n:nums2)
			System.out.print(n + "  ");
		
	}
}
