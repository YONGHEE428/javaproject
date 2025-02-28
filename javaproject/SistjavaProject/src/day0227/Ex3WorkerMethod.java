package day0227;

class Myinfo{
	private String name;
	private int age;
	
	//setter 메서드
	public void setname (String name) {
		this.name = name;
	}
	public void setage(int stage) {
		age = stage;
	}
	
	//getter 메서드
	public String getname(){
		return name;
	}
	public int getage() {
		return age;
	}
}
public class Ex3WorkerMethod {

	public static void main(String[] args) {
		
		Myinfo c1 = new Myinfo();
		Myinfo c2 = new Myinfo();
		
		c1.setname("박용희");
		c1.setage(26);
		
		c2.setname("조태민");
		c2.setage(26);
		
		System.out.println("이름 : "+c1.getname()+" | 나이 : "+c1.getage());
		System.out.println("이름 : "+c2.getname()+" | 나이 : "+c2.getage());
	}
}
