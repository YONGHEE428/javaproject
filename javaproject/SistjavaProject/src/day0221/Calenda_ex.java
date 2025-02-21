package day0221;

import java.util.Random;
import java.util.Scanner;

public class Calenda_ex {

		 public static void main(String[] args) {
			 
		        Scanner sc = new Scanner(System.in);
		        Random rand = new Random();

		        // 1~100 사이의 랜덤한 숫자 생성
		        int targetNumber = rand.nextInt(100) + 1;
		        
		        int guess;  // 사용자의 추측
		        int attempts = 0;  // 시도 횟수

		        System.out.println("1부터 100까지의 숫자를 맞춰보세요!");

		        // 사용자가 숫자를 맞출 때까지 반복
		        while (true) {
		            System.out.print("숫자를 입력하세요: ");
		            guess = sc.nextInt();
		            attempts++;  // 시도 횟수 증가

		            // 숫자가 맞았는지 확인
		            if (guess < targetNumber) {
		                System.out.println("더 큰 숫자입니다!");
		            } else if (guess > targetNumber) {
		                System.out.println("더 작은 숫자입니다!");
		            } else {
		                System.out.println("축하합니다! " + attempts + "번 만에 맞췄습니다!");
		                break;  // 숫자를 맞췄으면 반복 종료
		            }
		        }

		        sc.close();  // Scanner 닫기
		    }
		}