package day0221;

public class GuguGaro_11 {

	public static void main(String[] args) {
		
		System.out.println("\t가로 방향 구구단 출력");
		
		
		for (int n = 2; n <= 9; n++)
		{
			System.out.print("   [" + n + "단]\t\t");
		}
		
		
		for (int j = 1; j <=10; j++)
		{
			for(int i = 2; i<=9; i++)
			{
				System.out.printf("%d x %d = %d\t", i,j,i*j);
			}
			System.out.println("");
		}
	}
}
