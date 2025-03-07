package day0307;

import java.util.List;
import java.util.Vector;

public class Ex5List {

	public static void hochul(String title, List<String > list) {
		
		System.out.println("******* " + title + "*******");
		for (int i = 0; i < list.size(); i ++)
			System.out.print(list.get(i)+ " ");
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		String [] data = {"피자", "햄버거","비빔밥","초밥","된장찌개"};
		
		List<String> list = new Vector<String>();
		
		for(String d : data)
			list.add(d);
		
		hochul("출력한당", list);
		
		System.out.println("1번인덱스 삭제");
		
		list.remove(1);
		hochul("1번인덱스 지웠당", list);
		
		list.add(3, "한우");
		hochul("한우 추가", list);
		
		list.set(1, "육회비빔밥");
		hochul("육회비빔밥으로 수정", list);
		
		list.clear();
		hochul("삭제함ㅋ", list);
		System.out.println("데이타 여부: "+list.size());
	}
}
