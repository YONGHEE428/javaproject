package day0225;

import java.util.Scanner;

public class ex_10 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String num; // 메뉴 선택
        int n = 0; // 학생 수
        int[] scorelist = null; // 점수 리스트
        int tot = 0; // 총 점수
        
        while (true) {
            
            System.out.println("-----------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3. 점수리스트 | 4. 분석 | 5.종료");
            System.out.println("-----------------------------------------------");
            System.out.print("선택> ");
            num = sc.nextLine();
            
            if (num.equals("1")) { // 학생 수 
                System.out.print("학생 수를 입력하시오: ");
                n = Integer.parseInt(sc.nextLine());
                scorelist = new int[n];
            }
            else if (num.equals("2")) { // 점수 입력
                if (n == 0) {
                    System.out.println("먼저 학생 수를 입력하세요.");
                    continue;
                }
                tot = 0; // 
                for (int i = 0; i < n; i++) {
                    System.out.print("scores[" + i + "]> ");
                    scorelist[i] = Integer.parseInt(sc.nextLine());
                    tot += scorelist[i]; // 점수 합산
                }
            }
            else if (num.equals("3")) { // 점수 리스트
                if (scorelist == null || n == 0) {
                    System.out.println("점수가 입력되지 않았습니다.");
                } else {
                    for (int i = 0; i < n; i++) {
                        System.out.println("score[" + i + "]: " + scorelist[i]);
                    }
                }
            }
            else if (num.equals("4")) { // 분석
                if (scorelist == null || n == 0) {
                    System.out.println("점수가 입력되지 않았습니다.");
                } else {
                    double avg = (double) tot / n; // 평균 계산
                    System.out.println("합계 : " + tot + "점");
                    System.out.println("평균 : " + avg + "점");
                }
            }
            else if (num.equals("5")) { // 프로그램 종료
                System.out.println("프로그램 종료");
                break;
                
            } else { // 잘못된 선택 처리
                System.out.println("잘못된 선택입니다.");
            }
        }
    }
}
