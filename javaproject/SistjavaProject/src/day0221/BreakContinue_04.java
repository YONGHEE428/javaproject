package day0221;

public class BreakContinue_04 {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 10; i++)
		{
			if (i % 5 == 0)
				break;
			System.out.print(i + "  ");
		}
		System.out.println("");
		System.out.println("===========================");
		
		for(int i = 1; i <= 10; i++)
		{
			if (i % 5 == 0)
				continue;
			System.out.print(i + "  ");
		}
	}
}
