package day0307;

import java.net.MulticastSocket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex1HashSet문법 {

	//컬렉션_자료구조(Set,Vector,ArrayList,Map)
	//제네릭_명시한 자료형
	//(인터페이스)(인스턴스변수명) = new (클래스명) <데이터형>;
	//(클래스)(인스턴스변수명) = new (클래스명) <데이터형>;
	
	//List : 순서가 중요할때, 인덱스번호를 알고있다,중복가능
	//Set : 순서가 안지켜짐,중복허용을 안함
	//Map : 키<K>에 대한 값<V>을 구함
	public static void main(String[] args) {
		
		Set<String> set1 = new HashSet<String>();
		
		set1.add("안녕하세염");
		System.out.println(set1);
		set1.add("고양이");
		System.out.println(set1);
		System.out.println("데이터 개수: " + set1.size());
		
		System.out.println("출력 #1");
		for(String s : set1)
			System.out.println(s);
		System.out.println();
		
		System.out.println("출력 #2");
		Iterator<String> iter1 = set1.iterator();
		
		
		while(iter1.hasNext())
		{
			String s = iter1.next();
			System.out.println(s);
			
		}
		System.out.println();
		System.out.println("출력 #3");
		Object [] ob = set1.toArray();
			
		for(int i = 0; i <ob.length; i ++)
			System.out.println(ob[i]);
		System.out.println();	
		
		//모든데이타 삭제
		set1.clear();
		
		if(set1.isEmpty())
			System.out.println("Set타입안에 데이타가 없다");
		else
			System.out.println("Set타입안에 데이타가 있따.");
		
		
		
	}	
			
}
	

