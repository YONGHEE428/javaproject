package day0225;

public class ArrayIntTemp중요_04 {

	public static void main(String[] args) {
		// 배열안의 숫자 순서를 바꾸어 출력해보기
		
		int [] nums = {11,11,11,99,99,37,8,52};
		
		for (int i = 0; i<nums.length; i++)
			System.out.print(nums[i] + "  ");
		System.err.println(" ");		
		System.out.println("거꾸로 데이터출력");
		
		for (int i = 0; i < nums.length/2; i++)
		{
			int temp = nums[i];
			nums[i] = nums[nums.length-1-i];
			nums[nums.length-1-i] = temp;
		}
		for (int n : nums)
			System.out.print(n + "  ");
		
		System.out.println("\n===========================");
		System.out.println("작은수부터 차례대로 출력");
		
		for (int i=0; i <nums.length-1; i++)
		{
			for(int j = i+1; j < nums.length; j++)
			{
				if (nums[i] > nums[j])
				{
					int temp2 = nums[i];
					nums[i] = nums[j];
					nums[j] = temp2;
				}
			}	
		}
			for (int n :nums)
				System.out.print(n + "  ");
			
		System.out.println("\n===========================");
		System.out.println("중복시 몇개인지 알려주기");
		
		//이건 나중 문제 (0225)현재로썬 아직 배우지 않음
			boolean[] visited = new boolean[nums.length]; // 숫자가 이미 처리되었는지 확인하는 배열
			
			for(boolean n : visited)
				System.err.print(n+ "  ");
			System.out.println("");
	        
			for (int i = 0; i < nums.length; i++) {
	            if (visited[i]) {
	                continue;  // 이미 처리한 숫자는 건너뛰기
	            }

	            int count = 1; 

	            // 중복된 숫자 체크
	            for (int j = i + 1; j < nums.length; j++) {
	                if (nums[i] == nums[j]) {
	                    count++;  
	                    visited[j] = true;  // True면 확인한거다
	                }
	            }

	            // 중복된 숫자가 2번 이상 발견되면 출력
	            if (count > 1) {
	                System.out.println(nums[i] + " 숫자가 " + count + "번 중복입니다.");
	                visited[i] = true;  // 현재 숫자도 이미 확인한 것으로 처리
	            }
	        }
			for(boolean n : visited)
				System.err.print(n+ "  ");
	    }
	}
