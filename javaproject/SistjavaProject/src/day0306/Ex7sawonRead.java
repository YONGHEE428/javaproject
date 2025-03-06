package day0306;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

public class Ex7sawonRead {

	public static void read() {
		
		String filename = "C:\\SIST0217\\work\\sawon.txt";
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			int cnt = 1;
			int faSu = 0;
			int timeSu = 0;
			int tot = 0;
			System.out.println("번호 사원명 \t기본급\t\t가족수\t초과근무시간\t 가족수당\t\t시간수당\t\t총급여");
			System.out.println("-".repeat(100));
			
			while(true) {
				String s = br.readLine();
				
				if (s == null)
					break;
				
				String [] data = s.split(",");
				
				faSu = Integer.parseInt(data[2]) * 30000;
				timeSu = Integer.parseInt(data[3]) * 15000;
				tot = faSu + timeSu + Integer.parseInt(data[1]);
				NumberFormat nf1 = NumberFormat.getCurrencyInstance();
				System.out.println(cnt + "번  " + data[0] + "\t" + nf1.format(Integer.parseInt(data[1])) + "원\t" + data[2] + "명\t" + data[3] + "시간\t\t "
										+ nf1.format(faSu) + "원\t " + nf1.format(timeSu) + "원\t" + nf1.format(tot) + "원");
				cnt++;
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
		
		Ex7sawonRead.read();
	}
}
