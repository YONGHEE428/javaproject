package day0310;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BtnEventColor6 extends JFrame{

	Container cp;
	JButton btn1, btn2;
	

	//생성자
	public BtnEventColor6(String title) {
		super(title);
		
		//위치 너비
		this.setBounds(500, 250, 1000, 500);
		//색상
		cp = this.getContentPane();
		cp.setBackground(new Color(150,225,225));

		setDegign();
		
		this.setVisible(true);
	}
	
	//디자인
	public void setDegign() {
		this.setLayout(new FlowLayout());
		btn1 = new JButton("배경색을 핑크로 변경");
		btn2 = new JButton("배경색을 블루로 변경");
		
		btn1.setBackground(Color.pink);
		btn2.setBackground(Color.blue);
		btn1.setForeground(Color.white);
		btn2.setForeground(Color.white);
		
		this.add(btn1);
		this.add(btn2);
		//익명내부클래스로 이벤트 부여
	
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.setBackground(Color.magenta);
				
			}
		});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cp.setBackground(Color.blue);
			}
		});
	}
	//이벤트

	
	public static void main(String[] args) {
		new BtnEventColor6("배경변경이벤트 #6");
	
	}

}
