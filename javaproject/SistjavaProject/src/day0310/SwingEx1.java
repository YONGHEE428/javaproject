package day0310;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class SwingEx1 extends JFrame {

	Container cp;
	
	//생성자
	public SwingEx1(String title) {
		super(title); //JFrame 부모생성자를 통해서 창제목을 통해서 제목을 보게하자
		
		//위치 너비
		this.setBounds(800, 250, 300, 500);
		this.setVisible(true);
		//색상
		//this.getContentPane().setBackground(Color.GREEN); //Color클래스의 상수변화
		//this.getContentPane().setBackground(new Color(102,051,000)); //직접 rgb표를 통해 생 변화
		
		cp = this.getContentPane();
		cp.setBackground(new Color(102,120,0));
	}
	
	
	public static void main(String[] args) {
		new SwingEx1("연습창");

		
	}
}
