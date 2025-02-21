package day0221;

public class GuguFor_05 {

	public static void main(String[] args) {
		// 2 ~ 9단까지의 구구단
		
		for (int i = 2; i < 10; i++)
		{
			for (int j = 1; j <= 10; j++)
			{
				int n = i * j;
				System.out.printf("%d x %d = %d\t", i, j, n);
			}
			System.out.println("");
		}
		System.out.println("=============================================================================================================================================================");
	
		for (int j = 1; j <+ 10; j++)
		{
			for (int i = 2; i < 10; i++)
			{
				int n = i * j;
				System.out.printf("%d x %d = %d\t", i, j, n);
			}
			System.out.println("");
		}
	
	
	}
}
