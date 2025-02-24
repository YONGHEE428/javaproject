package day0224;

public class ForReviewStar_01 {

	public static void main(String[] args) {
		
		System.out.println("** 다중 For문으로 star(*)출력하기 **");
		
		for(int i=1; i <=5; i++)
		{
			for(int j = i; j <= 5; j++)
			{
				System.out.printf("*");
			}
			System.out.println("");
		}
		System.out.println("==================");
		for(int i=1; i <=5; i++)
		{
			for(int j = 1; j <= i; j++)
			{
				System.out.printf("*");
			}
			System.out.println("");
		}
	}
}
