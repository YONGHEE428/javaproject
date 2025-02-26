package day0226;

public class QuizObjectTest {

	public static void main(String[] args) {
		
		QuizObject.classname = "쌍용 교육센터 자바교육 4강의장";
		
		QuizObject c1 = new QuizObject();
		QuizObject c2 = new QuizObject();
		
		c1.stname2 = "손흥민";
		c1.stage2 = 29;
		c1.stcity2 = "부산";
		c1.sthobby2 = "헬스";
		
		c2.stname2 = "김연아";
		c2.stage2 = 26;
		c2.stcity2 = "서울";
		c2.sthobby2 = "여행";
		
		System.out.println("******메서드 사용 안한거*******");
		System.out.println("과정명 : " + QuizObject.classname);
		System.out.println("=================================");
		System.out.println("학생 1정보");
		System.out.println("이름: "+c1.stname2 );
		System.out.println("나이: "+c1.stage2 );
		System.out.println("지역: "+c1.stcity2 );
		System.out.println("취미: "+c1.sthobby2 );
		System.out.println();
		System.out.println("학생 2정보");
		System.out.println("이름: "+c2.stname2 );
		System.out.println("나이: "+c2.stage2 );
		System.out.println("지역: "+c2.stcity2 );
		System.out.println("취미: "+c2.sthobby2 ); 
		
		
		//캡슐화 setter, getter 메서드 사용
		c1.setName("손흥민");
		c1.setAge(29);
		c1.setCity("부산");
		c1.sethobby("헬스");
		
		c2.setName("김연아");
		c2.setAge(26);
		c2.setCity("서울");
		c2.sethobby("여행");
		System.out.println("\n********메서드 사용 한거*********");
		System.out.println("과정명 : " + QuizObject.classname);
		System.out.println("=================================");
		System.out.println("학생 1정보");
		System.out.println("이름: " +c1.getName());
		System.out.println("나이: " +c1.getAge());
		System.out.println("지역: " +c1.getCity());
		System.out.println("취미: " +c1.getHobby());
		System.out.println();
		System.out.println("학생 2정보");
		System.out.println("이름: " +c2.getName());
		System.out.println("나이: " +c2.getAge());
		System.out.println("지역: " +c2.getCity());
		System.out.println("취미: " +c2.getHobby());
		
	}
}
