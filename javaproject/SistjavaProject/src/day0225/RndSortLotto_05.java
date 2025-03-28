package day0225;

public class RndSortLotto_05 {

	public static void main(String[] args) {
		
		int [] lotto = new int[6];
		
		//임의의 수를 로또 변수에 발생시켜서 넣어준다
		for (int i = 0; i < lotto.length; i++)
		{
			lotto[i] = (int)(Math.random()*45)+1;
			
			//중복처리 : 현재 index(i) 와 (0~i-1)비교해서 중복된 숫자가 존재하면 i--
			for (int j = 0; j < i; j++)
			{
				if(lotto[i] == lotto[j])
				{	
					i--;
					break;
				}
			}
		}
		System.out.print("로또 번호 : ");
		for (int n :lotto)
			System.out.print(n + "  ");
		System.out.println("\n===============================");
		System.out.println("\t  오름차순 정리");
		System.out.println("===============================");
		for (int i=0; i <lotto.length-1; i++)
		{
			for(int j = i+1; j < lotto.length; j++)
			{
				if (lotto[i] > lotto[j])
				{
					int temp2 = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp2;
				}
			}	
		}
		System.out.print("로또 번호 : ");
		for (int n :lotto)
			System.out.print(n + "  ");
	}
}
