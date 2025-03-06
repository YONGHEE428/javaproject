package day0306;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ex5FruitRead {

	public static void read() {
		
		String filename = "C:\\SIST0217\\work\\fruit.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			int pay = 0;
			int cnt = 1;
			System.out.println("**과일 입고 현황**");
			System.out.println("번호\t과일명\t입고수량\t입고단가\t총금액");
			System.out.println("-".repeat(40));
			
			while(true) {
				String s = br.readLine();
				
				if(s == null)
					break;
				
				String [] data =s.split(":");
				pay = Integer.parseInt(data[1]) * Integer.parseInt(data[2]);
				
				System.out.println(cnt + "번\t" + data[0] + "\t" + data[1] + "개\t" + data[2] + "원\t" + pay + "원");
				cnt++;
			}
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		
		Ex5FruitRead.read();
	}
}
