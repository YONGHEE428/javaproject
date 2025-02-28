package day0227;

public class Ex11Member {

	static int cnt = 0;
	static String ban;
	
	private String stuName;
	private String stuGender;
	private String stuAddr;
	
	public void set(String stuName, String stuGender, String stuAddr) {
		this.stuName = stuName;
		this.stuGender = stuGender;
		this.stuAddr = stuAddr;
	}

	public void GetMember() {
		cnt++;
		System.out.println("***학생"+cnt+" 의 학생 정보***");
		System.out.println("이름 : " + this.stuName + " | 소속학급: "+Ex11Member.ban + " | 성별: " + stuGender + " | 주소 : " + stuAddr + "\n");
	}
}
