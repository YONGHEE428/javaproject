package day0227;

public class Em11MemberTest {

	public static void main(String[] args) {
		// 멤버 2명 객체 생성후 출력
		
		Ex11Member.ban = "쌍용교육센터";
		
		Ex11Member s1 = new Ex11Member();
		s1.set("박용희", "남", "서울");
		s1.GetMember();
		
	
		s1.set("김연아", "여", "부산");
		s1.GetMember();
		
		
		s1.set("손흥민", "남", "인천");
		s1.GetMember();
	}
}
