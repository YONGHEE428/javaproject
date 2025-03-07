package day0307;

import java.util.List;
import java.util.Vector;

@FunctionalInterface
interface MySwon{
	public void sawonAdd(String name);
	
}

@FunctionalInterface
interface Sales{
	public void sangpumAdd(String sangpum,int su ,int dan);
}

public class Ex9RamdaTest {

	
	MySwon sawon1 =(name)->System.out.println(name + " 사원을 추가함!!!");
	
	Sales sale = (sangpum,su,dan)-> System.out.println(sangpum + "을 개당 " +dan +"원 가격으로 " + su + "개를 추가한다. 총금액은---> " + dan*su+"원이다");
	
	public static void main(String[] args) {
		Ex9RamdaTest ex9 = new Ex9RamdaTest();
		ex9.sawon1.sawonAdd("박용희");
		ex9.sawon1.sawonAdd("조태민");
		ex9.sale.sangpumAdd("사과", 20, 2000);
		System.out.println();
		
		List<String> list1 = new Vector<String>();
		
		list1.add("사과");
		list1.add("오렌지");
		list1.add("바나나");
		list1.add("포도");
		list1.add("사과");
		
		for(String s:list1)
			System.out.println(s);
		
		list1.forEach(s->System.out.println(s));
		
	}
}
