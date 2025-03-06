package day0306;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Ex8FileWriter {

	public static void filewrite() {
		String filename = "C:\\SIST0217\\work\\test1.txt";
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(filename);
			
			//파일에 내용 추가
			fw.write("오늘 날씨 좋구나\n");
			fw.write(new Date().toString());
			
			System.out.println("**파일저장성공**");
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
	
	public static void filewrite2() {
		String filename = "C:\\SIST0217\\work\\test2.txt";
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(filename, true);
			
			fw.write("\n추가된 메세지입니다.\n");
			fw.write("-".repeat(50)+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		//Ex8FileWriter.filewrite();
		filewrite2();
	}
}
