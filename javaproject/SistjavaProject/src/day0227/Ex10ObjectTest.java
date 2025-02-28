package day0227;

class Jungbo{
	private String name;
	private int age;
	private String job;
	private String hobby;
	
	//setter / getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	//출력 메서드
	public void writeJunbo() {
		System.out.println("이름: "+this.name +  " | 나이: "+ this.age + " | 직업: "+ this.job + " | 취미: "+ this.hobby);
	}
	
}
////////////////////////////////////////////////////////
public class Ex10ObjectTest {

	public static void main(String[] args) {
		
		Jungbo j = new Jungbo();
		
		j.writeJunbo();
		
		j.setName("박용희");
		j.setAge(26);
		j.setJob("학생");
		j.setHobby("여행");
		j.writeJunbo();
		
		//2번째 객체 생성 setter / getter 메서드 사용
		
		Jungbo j2 = new Jungbo();
		
		j2.setName("김연아");
		j2.setAge(31);
		j2.setJob("연예인");
		j2.setHobby("피켜스케이트");
		
		System.out.println("이름: "+j2.getName() +  " | 나이: "+ j2.getAge() + " | 직업: "+ j2.getJob() + " | 취미: " + j2.getHobby());
	}
}
