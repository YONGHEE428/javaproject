package day0306;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex10FileReadWirte {

	static final String FILENAME = "C:\\SIST0217\\work\\sungjuk.txt";
	FileReader fr;
	BufferedReader br;
	FileWriter fw;
	Scanner sc = new Scanner(System.in);
	
	public int getMenu() {
		int num = 0;
		System.out.print("1.추가\t2.전체출력    3.종료 ");
		num = Integer.parseInt(sc.nextLine());
		return num;
	}
	
	public void sungjukInput() {
		
		System.out.print("학생명을 입력하시오: ");
		String name = sc.nextLine();
		System.out.print("점수를 입력하세요: ");
		int score = Integer.parseInt(sc.nextLine());
		
		try {
			fw = new FileWriter(FILENAME,true);
			
			fw.write(name + "\n");
			fw.write(score+ "\n");
			
			System.out.println("**학생 정보 입력 완료!**");
			System.out.println("-".repeat(50));
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
///////////////////////////////////////////////////
	public void sungjukOutput() {
		System.out.println("\t***학생정보*** ");
		System.out.println("번호\t학생명\t점수\t학점");
		System.out.println("-".repeat(50));
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			int num = 1;
			
			while (true) {
				String name = br.readLine();
				if(name == null)
					break;
				int score = Integer.parseInt(br.readLine());
				
				System.out.println(num + "번\t" + name + "\t" + score + "점\t" + getScore(score));
				
				num++;
			}
			
			System.out.println("-".repeat(50));
			
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
//////////////////////////////////////////
	public char getScore(int score) {
		char grade=switch(score/10) {
		case 10,9 -> 'A';
		case 8 -> 'B';
		case 7 -> 'C';
		case 6 -> 'D';
		default -> 'F';
		};
		return grade;
	}
	//////////////////////////////////////////
	public static void main(String[] args) {
		Ex10FileReadWirte ex10 = new Ex10FileReadWirte();
		
		while(true) {
			int num = ex10.getMenu();
			
			if(num == 1) {
				System.out.println("학생정보입력");
				ex10.sungjukInput();
			}
			if(num == 9) {
				System.out.println("프로그램 종료");
				break;
			}
			if (num == 2) {
				ex10.sungjukOutput();
			}
		}
		
	
	}
}
