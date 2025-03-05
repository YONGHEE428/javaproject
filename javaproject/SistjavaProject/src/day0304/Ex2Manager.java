package day0304;

//자식
public class Ex2Manager extends Ex2Employee{

	String dept;
	
	public Ex2Manager(String name, int sal, String dept) {
		super(name, sal); // 부모생성자 호출 this.sName = name, this.salary = sal
		this.dept = dept;
		
	}

	//오버라이딩
	@Override
	public String getEmp() {
		return super.getEmp()+ " , " + dept;
	}
	
}
