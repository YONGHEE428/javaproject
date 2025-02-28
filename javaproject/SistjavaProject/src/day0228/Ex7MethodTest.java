package day0228;

class Score{
	private String name;
	private int java;
	private int oracle;
	private int spring;
	public static final String TITLE = "중간고사 결과";

	//setters , getters 메서드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getOracle() {
		return oracle;
	}
	public void setOracle(int oracle) {
		this.oracle = oracle;
	}
	public int getSpring() {
		return spring;
	}
	public void setSpring(int spring) {
		this.spring = spring;
	}
	
	//추가.. 합계
	public int getTot () {
		int tot = java + oracle + spring;
		return tot;
	}
	//평균
	public double getAvg() {
		double avg = getTot() / 3;
		return avg;
	}
	
}

public class Ex7MethodTest {
	
	public static void main(String[] args) {
		
		Score sc = new Score();
	
		sc.setName("박용희");
		sc.setJava(88);
		sc.setOracle(77);
		sc.setSpring(66);
		
		System.out.println("이름\t자바\t오라클\t스프링\t합계\t평균");
		System.out.printf("%s\t%d점\t%d점\t%d점\t%d점\t%.2f",sc.getName(),sc.getJava(),sc.getOracle(),sc.getSpring(),sc.getTot(),sc.getAvg());
	}
}
