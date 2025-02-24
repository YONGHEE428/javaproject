package day0224;

public class FindArraymaxmin_11 {

	public static void main(String[] args) {
		
		int [] nums = {45,3,99,65,77,54,21,35,9,8,7,26};
		System.out.println("nums의 갯수: " +nums.length);
		
		int max = nums[0]; // 첫데이타를 무조건 최대값으로 지정
		int min = nums[0];
		
		for(int i = 1; i<nums.length; i++)
		{
			if(max<nums[i])
				max = nums[i];
			if (min>nums[i])
				min = nums[i];
		}
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
	}
}
