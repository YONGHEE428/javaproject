package day0304;

import day0228.StudentScoreResult;

//부모
class School{
	public static final String SCHOOLNAME = "쌍용고등학교";
	private String schoolAddr;
	private int countStu;
	private int countTeacher;
	
	public static String getSchoolname() {
		return SCHOOLNAME;
	}
	public School() {
		this("걍남구", 200,15); // 다른 생성자 호출 this()
	}
	public School(String addr, int cntS,int cntT) {
		 this.schoolAddr = addr;
		 this.countStu = cntS;
		 this.countTeacher = cntT;
	}
	public String getSchoolAddr() {
		return schoolAddr;
	}
	public void setSchoolAddr(String schoolAddr) {
		this.schoolAddr = schoolAddr;
	}
	public int getCountStu() {
		return countStu;
	}
	public void setCountStu(int countStu) {
		this.countStu = countStu;
	}
	public int getCountTeacher() {
		return countTeacher;
	}
	public void setCountTeacher(int countTeacher) {
		this.countTeacher = countTeacher;
	}
	//출력 메서드
	public void writeSchoolData() {
		System.out.println("학교주소 : " + this.schoolAddr );
		System.out.println("학생수 : " + this.countStu + " , 선생님수 : " + this.countTeacher);
	}
}
///////////////////////////
//자식
class Student extends School{
	
	String stuName;
	int score;
	
	public Student(){
		
	}
	
	public Student(String schoolAddr, int countStu, int countTeacher, String stuName, int score){
		super(schoolAddr, countStu, countTeacher);
		this.stuName = stuName;
		this.score = score;
	}
	//setter , getter
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public void writeSchoolData() {
		System.out.println("학교명: " + SCHOOLNAME);
		System.out.println("학생이름 : " + stuName);
		System.out.println("점수 : " + score);
		super.writeSchoolData();
	}
}

///////////////////////////
//메인
public class Ex6InheritTest {

	public static void main(String[] args) {
		Student sc2 = new Student();
		sc2.writeSchoolData();
		System.out.println("-----------------------------");
		Student sc = new Student("도봉구", 300, 25, "박용희", 85);
		sc.writeSchoolData();
		System.out.println("-------------------------------------");
		
		//수정
		sc2.setStuName("이수연");
		sc2.setScore(100);
		sc2.writeSchoolData();
	}
}
