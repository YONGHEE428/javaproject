package day0225;

public class ArrayStringTemp_06 {

	public static void main(String[] args) {
		
		String [] names = {"박용희","공찬혁","조태민","김민규","유혜지","원주희","현승윤"};
		
		System.out.println("**** 정렬 전 ****");
		
		for (int i =0; i < names.length; i ++)
			System.out.print(names[i]+ " ");
		
		System.out.println("\n**** 정렬 후 ****");
		
		for (int i = 0; i < names.length-1; i++)
		{
			for (int j = i+1; j < names.length; j++)
			{
				if (names[i].compareTo(names[j])>0)
				{
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
		}
		for (int i =0; i < names.length; i ++)
			System.out.print(names[i]+ " ");
	}
}
