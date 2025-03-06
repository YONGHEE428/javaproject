package day0306;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex9Filewiter {
	
	Scanner sc = new Scanner(System.in);
	FileWriter fw = null;
	static final String FILENAME = "C:\\SIST0217\\work\\member.txt";
	
	public void datewrite() {
		
		try {
			fw = new FileWriter(FILENAME,true);
			
			System.out.print("이름입력 : ");
			String name = sc.nextLine();
			System.out.print("핸드폰 번호 입력 : ");
			String number = sc.nextLine();
			System.out.print("주소입력 : ");
			String addr = sc.nextLine();
			
			
			System.out.println("Save");
			
			fw.write("회원명: " + name + "\n");
			fw.write("전화번호: " + number + "\n");
			fw.write("주소: " + addr + "\n------------------------------------------------\n");
			
			
			
		} catch (IOException e) {
	
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Ex9Filewiter ex9 = new Ex9Filewiter();
		ex9.datewrite();
	}
}
