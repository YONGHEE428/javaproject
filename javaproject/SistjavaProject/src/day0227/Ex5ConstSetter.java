package day0227;

public class Ex5ConstSetter {

	String name;
	int age;
	//생성자
	
	public Ex5ConstSetter (String name) {
		this.name = name;
	}
	
	public Ex5ConstSetter (String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
////////////////////////////////////////////////////////	
	public static void main(String[] args) {
		Ex5ConstSetter ex5 = new Ex5ConstSetter("홍길동");
		Ex5ConstSetter ex6 = new Ex5ConstSetter("김민지", 32);
		//Ex5ConstSetter ex7 = new Ex5ConstSetter();디폴트는 없음으로 에러
		System.out.println("이름은 "+ex5.getName()+"이고 나이는 "+ex5.getAge()+"세 입니다");
		System.out.println("이름은 "+ex6.getName()+"이고 나이는 "+ex6.getAge()+"세 입니다");
	}
}

