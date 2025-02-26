package day0226;

import java.util.Scanner;

public class ArrayRandomBingo_06 {

	public static void main(String[] args) {
		/*반복문 안에서 엔터를 누르면 다음 난수가 나오도록 설정 (종료 : Q or q)\
		 * 
		 * 3행 3열의 다차원 배열을 생성후 1~3사이의 난수를 발생
		 * 각각의 가로,각각의 세로,대각선을 비교해서 같은값이 나오고 빙고 : 2개 츨력
		 * 없으면 꽝!1 출력
		 */
		
		Scanner sc = new Scanner(System.in);
		int [] [] a = new int [3][3];
		int bingo=0;
		String start;
		
		while (true) {
		
			System.out.print("엔터를 눌러서 게임을 시작하세요");
			start = sc.nextLine();
			
			if (start.equalsIgnoreCase("q")) {
				System.out.println("게임을 종료합니다.");
				break;
			}
			
			else if (start.equals("")) {
				//빙고 생성
				System.out.println("******빙고 생성 *******");
				for (int i = 0; i < a.length; i ++) {
					for(int j = 0; j < a[i].length; j++) {
						a[i][j] = (int)(Math.random()*3)+1;
					}
				}
				int cnt = 0;
				// 가로,세로,대각선
				//가로
				for ( int i = 0; i<a.length; i ++) {
					for(int j = 0; j < 1; j++) {
						if(a[i][j] == a[i][j+1] && a[i][j] == a[i][j+2]) {
							cnt ++;
						}
					}
				}
				//세로
				for (int i = 0; i < 1; i++) {
					for (int j = 0; j< a.length; j++) {
						if (a[i][j] == a[i+1][j] && a[i][j] == a[i+2][j]) {
							cnt++;
						}
					}
					//가로
					/*if (a[i][0] == a[i][1] && a[i][1] == a[i][2])
						cnt++;
					//세로
					if (a[0][i] == a[1][i] && a[1][i] == a[2][i])
						cnt++;*/
				}
				if (a[0][0] == a[1][1] && a[1][1] == a[2][2])
					cnt++;
				if (a[0][2] == a[1][1] && a[1][1] == a[2][0])
					cnt++;
				
				//출력
				for(int i = 0; i < a.length; i ++) {
					for (int j = 0; j < a[i].length; j++) {
						System.out.print(a[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println("==============================");
				
				if (cnt > 0) {
					System.out.println("빙고" + cnt + "발견!!!");
				}
				else {
					System.out.println("꽝!!");
				}
					
					
			
			
	
			}
		
		
		}
		
		
	}
}
