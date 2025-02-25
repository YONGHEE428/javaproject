package day0225;

import java.util.Scanner;

public class QuizStartsWithSearch_09 {

	public static void main(String[] args) {
		
		String [] celeb = {"공유","신민아","이정재","손흥민","이강인","이효리","이진","손미나"};
		int cnt;
		Scanner sc = new Scanner(System.in);
		String search;
		boolean find;
		
		for(String n : celeb)
			System.out.print(n + " ");
		System.out.println("\n=============================================");
		
		while (true)
		{
			int count =0;
			System.out.print("검색할 성을 입력해주세요 : ");
			search = sc.nextLine();
			
			if (search.equals("종료")) {
				System.out.println("검색을 종료합니다.");
				break;
			}
			
			find = false;
			
			for (int i = 0; i<celeb.length; i++) {
				if(celeb[i].startsWith(search) == true){
					find = true;
					System.out.println((i+1) + ": " + celeb[i]);
					count++;
				}
			}
			if(find)
				System.out.println("***** 총 " + count + "명 검색 *****");
			if (!find)
				System.out.println(search + " 씨성을 가진 연예인은 없습니다.");
			/*if (count >0){
				System.out.println("***** 총 " + count + "명 검색 *****");
			} 
			else if (count == 0)
				System.out.println(search+" 씨성을 가진 연예인은 없습니다.");*/
			
		}	
	}
}
