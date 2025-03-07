package day0306;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QuizReadWrite {

	static final String FILENAME = "C:\\SIST0217\\work\\Quiz.txt";
	Scanner sc = new Scanner(System.in);
	FileReader fr;
	FileWriter fw;
	BufferedReader br;
	
	public int getMenu() {
		int num = 0;
		System.out.print("1.상품추가\t2.상품전체입고현황\t9.종료 : ");
		num = Integer.parseInt(sc.nextLine());
		return num;
	}
//////////////////////////////////////////////////////////////////	
	public void sangpumAdd() {
		System.out.print("삼풍명 : ");
		String name = sc.nextLine();
		System.out.print("수량 : ");
		int amount = Integer.parseInt(sc.nextLine());
		System.out.print("단가 : ");
		int pay = Integer.parseInt(sc.nextLine());
		
		try {
			fw = new FileWriter(FILENAME,true);
			
			fw.write(name + "," + amount + "," + pay + "\n");
			System.out.println("***상품추가 완료!!***");
			System.out.println("-".repeat(70));
			
		} catch (IOException e) {

			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
///////////////////////////////////////////////////////
	public void sangpumDatas() {
		System.out.println("\t\t*****상품전체 입고현황*****");
		System.out.println("번호\t상품명\t수량\t단가\t금액\t할인\t총금액");
		int cnt = 1;
		int price = 0;
		int total = 0;
		int halin = 0;
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			while(true) {
				String s = br.readLine();
				
				if(s == null)
					break;
				
				String [] data = s.split(",");
				
				price = Integer.parseInt(data[1]) * Integer.parseInt(data[2]);
				if (Integer.parseInt(data[1])>10)
					halin = (int)(price *0.1);
				else
					halin = 0;
				total = price - halin;
				System.out.println(cnt + "번\t" + data[0] + "\t" + data[1] + "개\t" + data[2] + "원\t" + price + "원\t" + halin + "원\t" + total + "원");
				cnt++;
			}
		
			System.out.println("-".repeat(70));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
//////////////////////////////////////////////////////////////////////	
	public static void main(String[] args) {
		QuizReadWrite q = new QuizReadWrite();
		
		while(true) {
			int num = q.getMenu();
			
			if (num == 1) {
				q.sangpumAdd();
			}
			if( num == 2) {
				q.sangpumDatas();
			}
			if(num == 9) {
				System.out.println("종료합니다.");
				break;
			}else
				System.out.println("번호를 다시 입력하세요.");
	}

}
}