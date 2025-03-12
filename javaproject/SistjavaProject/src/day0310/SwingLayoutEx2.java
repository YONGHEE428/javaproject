package day0310;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingLayoutEx2 extends JFrame {

	Container cp;
	JButton jb1;

	//생성자
	public SwingLayoutEx2(String title) {
		super(title);
		
		//위치 너비
		this.setBounds(800, 250, 300, 500);
		//색상
		cp = this.getContentPane();
		cp.setBackground(new Color(150,255,245));
		
		//버튼 생성
		jb1 = new JButton("버튼1");
		
		//프레임에 버튼추가..기본이 BorderLayout..이경우는 추가할때 위치지정이 필수
		//this.add(jb1,BorderLayout.NORTH); // 위쪽
		//this.add(jb1,BorderLayout.SOUTH); // 아래쪽
		this.add("North", jb1); //첫글자가 반드시 대문자		
		
		//생성과 동시에 위치지정
		this.add("South",new JButton("아래쪽"));
		this.add("West",new JButton("왼쪽"));
		this.add("East",new JButton("오른쪽"));
		this.add("Center",new JButton("가운데"));
		
		//버튼1에 속성
		jb1.setBackground(Color.pink); //배경색
		jb1.setForeground(Color.green);
		
		
		
		this.setVisible(true); // 제일 맨 마지막에 적자
	}
	
	
	public static void main(String[] args) {
		new SwingLayoutEx2("스윙 기본 레이아웃 연습");
	
	}
}
