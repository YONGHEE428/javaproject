package day0228;

import java.util.Scanner;

class StudentScore{
	
	private String stuName;
	private int java;
	private int html;
	private int mysql;
	
	//setter , getter 메서드
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
	public int getMysql() {
		return mysql;
	}
	public void setMysql(int mysql) {
		this.mysql = mysql;
	}
	//총점 
	public int getTotal() {
		return getJava() + getHtml() + getMysql();
	}
	//평균 
	public double getAverage() {
		return (double)getTotal() /3;
	}
	//평가
	public String getPungga() {
		if(getAverage() >= 90) {
			return "장학생";
		}else if (getAverage() >= 80) {
			return "우수생";
		}else
			return "재수강";
	}
	//헤더 출력 메서드
	public static void showTitle() {
		System.out.println("이름\tJava\tHtml\tMysql\t총점\t평균\t평가");
		System.out.println("==========================================================");
	}

}
//////////////////////////////////////////////////////////////////////
public class StudentScoreResult {

	//출력 메서드
	public static void showPungga(StudentScore [] s) {
	    StudentScore.showTitle();
	    for(StudentScore st : s) {
	        System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n", st.getStuName(),st.getJava(),st.getHtml(), st.getMysql() ,
	            st.getTotal(), 
	            st.getAverage(),  
	            st.getPungga());
	    }
	}

	public static void main(String[] args) {
		
		int inwon;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생인원 수를 입력하시오: ");
		inwon = Integer.parseInt(sc.nextLine());
		StudentScore [] st = new StudentScore[inwon];
		
		//설정
		for(int i = 0; i < inwon; i++) {
			st[i] = new StudentScore();
			System.out.print((i+1)+"번 학생의 이름을 입력하시오: ");
			st[i].setStuName(sc.nextLine());
			System.out.print(st[i].getStuName()+" 학생의 Java점수: ");
			st[i].setJava(Integer.parseInt(sc.nextLine()));
			System.out.print(st[i].getStuName()+" 학생의 Html점수: ");
			st[i].setHtml(Integer.parseInt(sc.nextLine()));
			System.out.print(st[i].getStuName()+" 학생의 Mysql점수: ");
			st[i].setMysql(Integer.parseInt(sc.nextLine()));
			System.out.println("--------------------------------------------------");
		}
		//출력
		showPungga(st);
		
	}
}
