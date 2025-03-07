package day0307;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Ex3Set {

	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<Integer>();
		
		while (true)
		{
			//난수 발생
			int n =(int)(Math.random()*45)+1;
			
			//난수 set에 담기
			set.add(n);
			
			if(set.size() == 6) {
				break;
			}
		}
		System.out.println("출력1");
		for(Integer i : set)
			System.out.print(i +  "  ");
		
		System.out.println("\n출력2");
		Object [] ob = set.toArray();
		for(int i = 0; i < ob.length; i++)
			System.out.print(ob[i] + "  ");
		
		//오름차순
		Arrays.sort(ob);
		System.out.println("\n정렬후 출력");
		for(int i = 0; i < ob.length; i++)
			System.out.print(ob[i] + "  ");
		
	}
}
