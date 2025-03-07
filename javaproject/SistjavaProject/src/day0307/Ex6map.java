package day0307;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex6map {

	//key value로 이루어진 데이터 집합
	//key로 구분
	//순서는 유지되지 않는다
	//key는 중복허용하지 않는다
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "용희");
		map.put("age", "26");
		map.put("addr", "강남구역삼동");
		//같은 키값을 넣으면 기존에 데이타가 삭제된다
		map.put("name", "용박이");
		map.put("MBTI", "ESTP");
		System.out.println("Size : " +map.size());
		
		//키값을 알면 정확하게 value알수 있다
		System.out.println("이름 : " + map.get("name"));
		System.out.println("나이 : " + map.get("age"));
		System.out.println("주소 : " + map.get("addr"));
		System.out.println("앙: " + map.get("앙"));
		//key값을 한꺼번에 얻은 후 값을 열기
		System.out.println();
		Set<String> keySet = map.keySet();
		Iterator<String> KeyIter =keySet.iterator();
		
		while(KeyIter.hasNext())
		{
			String key = KeyIter.next();
			System.out.println(key+" => " + map.get(key));
		}
		
		System.out.println("\n방법2");
		for(String s : keySet)
			System.out.println(s + " => "+ map.get(s));
	}
}
