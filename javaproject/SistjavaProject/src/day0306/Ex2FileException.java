package day0306;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex2FileException {

	public static void SumNumber() {
		//총갯수 구하고 총점,평균 구하기
		
		String filename = "C:\\SIST0217\\work\\SumNumber.txt";
		BufferedReader br = null;
		FileReader fr = null;
		int cnt = 0; //갯수
		int total = 0; //총점
		double avg = 0; //평균
		
		//파일읽기
		try {
			fr = new FileReader(filename);
			System.out.println("파일 정상적으로 열림!!!");
			
			br = new BufferedReader(fr);
			
			while (true) {
				
				String s = br.readLine();
				
				if(s == null) {
					break;
				}
				
				//문자열점수를 int로 변환하여 합께와 갯수구하기
				cnt++;
				total += Integer.parseInt(s);
			}
			
			//평균
			avg = (double)total / cnt;
			
			System.out.println("총갯수 : " + cnt);
			System.out.println("총점 : " + total);
			System.out.printf("평균 : %.2f\n",avg);
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
		}finally {
			try {
				br.close();
				fr.close();
				
				System.out.println("파일을 닫았습니다.");
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Ex2FileException.SumNumber();
	}
}
