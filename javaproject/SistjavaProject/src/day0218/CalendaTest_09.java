package day0218;

import java.util.Calendar;
import java.util.Date;

public class CalendaTest_09 {
	
	public static void main(String[] args) {
		
		//import
		Calendar cal = Calendar.getInstance();
		
		//Date date = new Date();
		
		//출력
		
		//System.out.println("지금은 "+(date.getYear()+1900)+"년도 입니다.");
		System.out.println("지금은 " + cal.get(cal.YEAR)+"년도 입니다");
		System.out.println("지금은 " + (cal.get(cal.MONTH)+1)+ "월 입니다.");
		System.out.println("지금은 " + cal.get(cal.DATE)+"일 입니다.");
		System.out.println("지금은 " + cal.get(cal.HOUR_OF_DAY)+"시 " + cal.get(cal.MINUTE)+"분");
	}

}
