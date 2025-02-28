package day0227;

class Input {
	private String irum ;
	private String juso ;
	private int nai ;
	
	public Input() {
		
	}
	//생성자
	public Input(String irum, String juso, int nai) {
		this.irum = irum;
		this.juso = juso;
		this.nai = nai;
	}
	
	//setter / getter메서드
	public String getIrum() {
		return irum;
	}


	public void setIrum(String irum) {
		this.irum = irum;
	}


	public String getJuso() {
		return juso;
	}


	public void setJuso(String juso) {
		this.juso = juso;
	}


	public int getNai() {
		return nai;
	}


	public void setNai(int nai) {
		this.nai = nai;
	}

	public void set(String irum, String juso, int nai) {
		this.irum = irum;
		this.juso = juso;
		this.nai = nai;
	}
	public String getInputDatas() {
		String s = "이름: "+irum+"\n주소: " + juso + "\n나이: " + nai;
		return s;
	}
	
}
////////////////////////////////////////
public class Ex12ObjectTest {

	public static void main(String[] args) {
		
		//생성1 setter / getter
		Input ob1 = new Input();
		ob1.setIrum("박용희");
		ob1.setJuso("서울시");
		ob1.setNai(26);
		
		System.out.println("**값출력 하나하나 get메서드로 하기**");
		System.out.println("이름: " + ob1.getIrum());
		System.out.println("지역: " + ob1.getJuso());
		System.out.println("나이: " + ob1.getNai());
		
		//생성2 메서드사용
		System.out.println("**값입력도 3개 한번에 출력도 3개 한번에 하기**");
		Input ob2 = new Input();
		ob2.set("김연아", "부산시", 31);
		System.out.println(ob2.getInputDatas());
		
		//생성3 생성자 사용
		System.out.println("**생성자 사용**");
		Input ob3 = new Input("손흥민", "인천시", 37);
		System.out.println(ob3.getInputDatas());
		
	}
}
