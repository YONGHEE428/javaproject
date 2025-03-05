package day0305;

public class Ex15StringBuffer중요한가 {

	public static void main(String[] args) {
		
		String str = "Happy";
		//String -> StringBuffer
		StringBuffer sb = new StringBuffer(str);
		
		//인스턴스 변수인경우 변수명만 출력하면 자동으로 toString()호출
		//toString을 갖고있지않는경우 값이 아니라 주소가 출력된다
		System.out.println(sb);
		System.out.println(sb.toString());
		
		//String은 갑자체를 변경할 수 없지만 StringBuffer는 문자열 편집가능
		//맨뒤에 추가
		sb.append(" World");
		System.out.println(sb);
		
		//n번째바로뒤 추가
		sb.insert(5, ",");
		System.out.println(sb);
		
		//인데스n부터 n까지 삭제
		sb.delete(5, 6);
		System.out.println(sb);
		
		//인덱스n번째 삭제 (0부터~~~)
		sb.deleteCharAt(4);
		System.out.println(sb);
		
		//n번째 인덱스 글자 교체
		sb.replace(4,4,"y");
		System.out.println(sb);
		
		//문자열 뒤집기
		sb.reverse();
		System.out.println(sb);
		
		
	}
}
