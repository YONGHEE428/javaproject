package day0306;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex6Format {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		//날짜,시간을 원하는 양식으로 출력 HH :24시간표기 MM:월 mm:분
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf1.format(date));
		
		//a : 오전/오후 hh:12시간 표기
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
		System.out.println(sdf2.format(date));
		
		//EEE :요일 짧게  EEEE:요일 길게
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd EEEE HH:mm:ss");
		System.out.println(sdf3.format(date));
		
		
		//숫자는 문자열로 변환해서 출력
		int money =6580000;
		double num = 68.4589;
		
		
		NumberFormat nf1 = NumberFormat.getCurrencyInstance(); //원단위 화폐단위와 커마 제공
		System.out.println(nf1.format(money));
		
		NumberFormat nf2 = NumberFormat.getInstance(); //커마 제공
		System.out.println(nf2.format(num));
		System.out.println(nf2.format(money));
	}
}
