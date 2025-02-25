package day0225;

import java.util.Scanner;

public class ArrayIntIndex_01 {

	public static void main(String[] args) {
		//숫자배열중에서 내가 입력한 숫자가 있는지 있다면 몇번째인지 확인
		
		int [] nums = {5,65,44,99,88,75,32,19,52,36,55,66,33,42};
		
		// System.out.println(nums.length);
		Scanner sc = new Scanner(System.in);
		int su;
		boolean flag; // 숫자가 있는지 없는지에 대한 변수
		
		while (true)
		{
			System.out.print("검색할 숫자를 입력해주세요: ");
			su = Integer.parseInt(sc.nextLine());
			
			//종료 조건
			if (su == 0)
			{
				System.out.println("숫자 검색을 종료합니다.");
				break;
			}
			
			flag =false; // 찾으면 true로 변경
			
			//값찾기
			for (int i=0; i <nums.length; i++)
			{
				if (su == nums[i])
				{
					flag =true;
					System.out.println((i+1)+ "번째에서 " + su + " 숫자를 찾았습니다");
				}
			}
		if (!flag)	
		{
			System.out.println(su + "는 데이터에 없습니다.");
		}
		}
	}
}
