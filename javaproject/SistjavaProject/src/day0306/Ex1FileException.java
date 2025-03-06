package day0306;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1FileException {

	public static void read() {
		//경로 표시 = / , \\
		String fileName = "C:\\SIST0217\\work\\memo1.txt";
		BufferedReader br = null;
		FileReader fr = null;
		
		//읽기위해서 파일열기
		try {
			fr = new FileReader(fileName);		//filereader은 무조건 try catch 문을 써야한다
			System.out.println("파일을 열었어요!!!");
			
			br = new BufferedReader(fr);
			//여러줄을 읽어야 하므로 while문으로 읽어야 한다
			while(true) {
				//메모장에서 내용을 한줄씩 읽는다
				String s = br.readLine();
				//마지막줄일경우 null값을 읽는다, null값일경우 반복문 종료
				if (s == null)
					break;
				
				
				System.out.println(s);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {	
		}finally { //필수는 아니지만 그냥 무조건 하는게 낫다
			//close할땐 open반대순.생성의 역순으로 닫는다
			try {
				br.close();
				fr.close();

				System.out.println("**파일에 대한 자원 모두 닫았습니다.**");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		 Ex1FileException.read();
	}
}
