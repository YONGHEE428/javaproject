package day0307;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class Ex4List {

	public static void main(String[] args) {
		
		//List<String> list = new Vector<String>();
		Vector<String> list = new Vector<String>();
		//디폴트 생성자의 경우 기본할당 크기는 10이다 / 그러나 초기 크기는 0
		System.out.println("초기할당갯수 : " + list.capacity());
		System.out.println("초기데이타 갯수 : " + list.size());
		
		list.add("사과");
		list.add("오렌지");
		list.add("키위");
		list.add("오렌지");
		list.add("사과");
		
		System.out.println("초기할당갯수 : " + list.capacity());
		System.out.println("초기데이타 갯수 : " + list.size());
		
		System.out.println("\n출력 #1");
		
		for(String s : list)
			System.out.print(s + "  ");
		
		System.out.println("\n출력 #2");
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + "  ");
		
		System.out.println("\n출력 #3");
		
		Iterator<String> it = list.iterator();
		
		while (it.hasNext())
		{
			System.out.print(it.next() + "  ");
		}
	}
	
}
