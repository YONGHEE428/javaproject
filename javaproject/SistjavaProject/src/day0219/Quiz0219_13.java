package day0219;

import java.util.Scanner;

public class Quiz0219_13 {

		
	public static void main(String[] args) {
		/*입고된 상품명은? 아이폰16
				수량은? 6
				단가는? 1100000
				============================
				아이폰 6개는 총 6600000 입니다
				(단 5개 이상은 10프로 DC 됩니다)
				============================
				dc된 최종금액: 5940000원*/
		
		Scanner sc=new Scanner(System.in);
		String sangName;
		int su,dan,tot;
		int dc=0;
		
		System.out.print("입고된 상품명은?");
		sangName=sc.nextLine();
		System.out.print("수량?");
		su=sc.nextInt();
		System.out.print("단가는");
		dan=sc.nextInt();
		
		//계산
		tot=su*dan;
		System.out.println(sangName+" "+su+"개는 총"+tot+"원 입니다");
		
		
		if(su>=5) 
		{
			dc=tot*9/10;
			System.out.println("(단 5개 이상은 10프로 DC 됩니다)");
			System.out.println("dc된 최종금액:"+dc+"원");
		}
		
		

	}

}
