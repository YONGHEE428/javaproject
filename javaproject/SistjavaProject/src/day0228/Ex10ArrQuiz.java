package day0228;

import java.util.Scanner;

class StuInfos{
	private String stuName;
	private String mbti;
	private int age;
	
	//3가지인자 초기화하는 생성자
	public StuInfos(String name, String mbti, int age) {
		this.stuName = name;
		this.mbti = mbti;
		this.age = age;
	}
	public static void showTitle() {
		System.out.println("이름\tMBTI\t나이");
	}
	public void showInfo() {
		System.out.println(stuName + "\t" + mbti + "\t" + age);
	}
}
public class Ex10ArrQuiz {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StuInfos [] st = {
				new StuInfos("박용희", "ESTP", 26),
				new StuInfos("김연아", "ISTP", 57),
				new StuInfos("이찬성", "ENFP", 17),
				new StuInfos("박태준", "INTJ", 32),
				new StuInfos("김배짱", "ESFJ", 41)
		};		
		StuInfos.showTitle();
		for(int i =0; i <st.length; i++) {
			st[i].showInfo();
		}
	}
}
