package day0306;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ex4FlowersRead {

	public static void Read(){
		
		String filename = "C:\\SIST0217\\work\\flowers.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
		
			System.out.println("**꽃말 가격 정보**");
			System.out.println("꽃이름\t꽃말\t한단가격");
			System.out.println("-".repeat(50));
			
			while(true) {
				
				String s = br.readLine();
				
				if (s == null)
					break;
				//split
				/*String [] data = s.split(",");
				//배열갯수만큼 반복해서 출력
				System.out.println(data[0] + "\t" + data[1] + "\t" + data[2]);*/
				//StringTokenizer
				StringTokenizer st = new StringTokenizer(s, ",");
				System.out.println(st.nextToken() + "\t" + st.nextToken() + "\t" + st.nextToken() + "원");
				
			}
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		}catch (IOException e) {
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		
		Ex4FlowersRead.Read();
	}
}
