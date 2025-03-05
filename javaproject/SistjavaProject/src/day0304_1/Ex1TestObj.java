package day0304_1;

import day0304.Ex1SuperObj;
//	   자식				부모
class SubObj extends Ex1SuperObj {

	private String addr;
	//	 부모껄 자식이름으로
	public SubObj(String name, int age,String addr){
		super(name, age); // 반드시 첫줄,부모생성자 호출
		this.addr = addr;

	}

	public void writeData() {
		
		System.out.println("이름: "+this.name);
		System.out.println("나이: "+this.age);
		System.out.println("주소: "+this.addr);
	}
	
	
}
////////////////////////////////////////////////////////////
public class Ex1TestObj {

	public static void main(String[] args) {
		
		SubObj sub1 = new SubObj("박용희", 26, "서울시");
		sub1.writeData();
	}
}
