package day0307;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex2Set {

	public static void main(String[] args) {
		
		
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(88);
		set1.add(99);
		set1.add(77);
		
		System.out.println(set1);
		System.out.println("데이타 개수: " + set1.size());
		
		System.out.println();
		System.out.println("출력 #1");
		for(Integer i : set1)
			System.out.println(i);
		
		System.out.println();
		System.out.println("출력 #2");
		
		Iterator<Integer> iter = set1.iterator();
		while (iter.hasNext()) {
			Integer i = iter.next();
			System.out.println(i);
		}
		
		System.out.println();
		System.out.println("출력 #3");
		
		Object [] ob = set1.toArray();
		for (int i = 0; i < ob.length; i++)
			System.out.println(ob[i]);
		
		
		
	}
}
