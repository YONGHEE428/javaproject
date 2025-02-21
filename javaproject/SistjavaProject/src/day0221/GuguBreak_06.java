package day0221;

public class GuguBreak_06 {

	public static void main(String[] args) {
		
		for (int i = 2; i < 10; i++)
		{
			for (int j = 1; j <= 10; j++)
			{
				if (j ==5)
					continue;
				int n = i * j;
				System.out.printf("%d x %d = %d\t", i, j, n);
			}
			System.out.println("");
		}
		System.out.println("=============================================================================================================================================================");
	
		n1 : for (int i = 2; i < 10; i++)
		{
			for (int j = 1; j <= 10; j++)
			{
				if (j ==5)
					break n1;
				int n = i * j;
				System.out.printf("%d x %d = %d\t", i, j, n);
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("=============================================================================================================================================================");
	
	n2 : for (int j = 1; j <+ 10; j++)
		{
			for (int i = 2; i < 10; i++)
			{
				if (j ==5)
					break;
				int n = i * j;
				System.out.printf("%d x %d = %d\t", i, j, n);
			}
			System.out.println("");
		}
		System.out.println("=============================================================================================================================================================");
		
	n2 : for (int j = 1; j <+ 10; j++)
		{
			for (int i = 2; i < 10; i++)
			{
				if (j ==5)
					break n2;
				int n = i * j;
				System.out.printf("%d x %d = %d\t", i, j, n);
			}
			System.out.println("");
		}
	}
}
