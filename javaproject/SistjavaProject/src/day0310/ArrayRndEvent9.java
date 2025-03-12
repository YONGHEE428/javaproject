package day0310;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ArrayRndEvent9 extends JFrame {

	Container cp;
	JButton btnRandom;
	JLabel [] lblFood = new JLabel[9];
	String [] str = {"짜장면","짬뽕","탕수육","햄버거","피자","라면","삼겹살","치킨","콩국수"};
	//생성자
	public ArrayRndEvent9(String title) {
		super(title);
		
		//위치 너비
		this.setBounds(600, 100, 800, 900);
		//색상
		cp = this.getContentPane();
		cp.setBackground(new Color(125,250,250));

		setDegign();
		
		this.setVisible(true);
	}
	
	//디자인
	public void setDegign() {
		//패널을 프레임의 센터에 추가
		JPanel panel = new JPanel(new GridLayout(3,3));
		this.add(panel);
	
		//라벨을 패널에 추가
		for(int i=0;i<lblFood.length;i++) {
			lblFood[i] = new JLabel(str[i],JLabel.CENTER);
			int r = (int)(Math.random()*256);
			int g = (int)(Math.random()*256);
			int b = (int)(Math.random()*256);
			lblFood[i].setBackground(new Color(r,g,b));
			
			//라벨의 투명도
			lblFood[i].setOpaque(true);
			
			//패널의 라벨 추가
			panel.add(lblFood[i]);
		}
		//프레임의 하단에 버튼생성후 추가
		btnRandom = new JButton("라벨 색상 변경");
		this.add(btnRandom,BorderLayout.SOUTH);
		//이벤트
		btnRandom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<lblFood.length;i++) {
					int r = (int)(Math.random()*256);
					int g = (int)(Math.random()*256);
					int b = (int)(Math.random()*256);
					lblFood[i].setBackground(new Color(r,g,b));
				}	
			}
		});
	}
	
	
	public static void main(String[] args) {
		new ArrayRndEvent9("스윙레이아웃 연습 #3");
	
	}
}
