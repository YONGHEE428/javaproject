package day0225;

import java.util.Scanner;

public class ArrayStringIndex_02 {

	public static void main(String[] args) {
		// 이름을 입력하여 몇번째에 있는지 찾기
		String [] stu = {"손현정","박호준","유혜지","원주희","김기범","이창연","박용희","김민규","조태민","공찬혁"};
		
		String st;
		boolean flag;
		
		Scanner sc = new Scanner(System.in);
		
		while (true)
		{
			System.out.print("검색할 이름을 작성하시오 : ");
			st = sc.nextLine();
			
			if (st.equals("끝"))
			{
				System.out.println("이름 찾기를 종료합니다.");
				break;
			}
			
			flag = false;
			
			for (int i=0; i< stu.length; i++)
			{
				if (st.equals(stu[i]))
				{
					flag =true;
					System.out.println((i+1)+"번째에서 ["+st+"]이름을 찾았습니다.");
				}
			}
			
			if(!flag)
				System.out.println("["+st+"]란 이름은 데이터에 없습니다");
		}
	}
}
