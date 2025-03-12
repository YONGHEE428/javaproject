package day0310;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BtnArrayEvent7 extends JFrame implements ActionListener{

	Container cp;
	JButton [] btn= new JButton[7];
	String [] btnLabel = {"Red","Yellow","Green","Blue","Cyan","While","Pink"};
	Color[] btnColor = {Color.red,Color.yellow,Color.green,Color.blue,Color.cyan,Color.white,Color.pink};
	//생성자
	public BtnArrayEvent7(String title) {
		super(title);
		
		//위치 너비
		this.setBounds(500, 250, 1000, 500);
		//색상
		cp = this.getContentPane(); // 이벤트 창 생성
		cp.setBackground(new Color(125,250,250)); // 창 크기 정하는거

		setDegign(); //디자인 메소드 
		
		this.setVisible(true); // 실행할수 있게 하는거
	}
	
	//디자인
	public void setDegign() {
		//panel은 기본이 FlowLayout
		JPanel panel = new JPanel(); // 파넬 객체 생성
		panel.setLayout(new GridLayout(7,1));
		panel.setBackground(Color.orange); // 파넬 색 설정
		
		//패널을 상단에 배치
        this.add(panel, BorderLayout.WEST); // 파넬 실행창에 집어넣고 위치 설정
        
		for(int i = 0; i<btn.length; i++) { // 배열로 버튼 생성
			btn[i] = new JButton(btnLabel[i]);
			btn[i].setBackground(btnColor[i]);
			 btn[i].setMaximumSize(new Dimension(200, 50));

			panel.add(btn[i]);
			btn[i].addActionListener(this);
		}
		
	}
	//이벤트
	@Override
	public void actionPerformed(ActionEvent e) { // 버튼의 이벤트 메소드
		Object ob = e.getSource(); // 이벤트 객체 생성
		
		for(int i = 0; i < btn.length; i++) // 각 버튼만다 이벤트 일어나게 선언
			if(ob == btn[i]) {
				cp.setBackground(btnColor[i]); //어떤 이벤트인지 설정
		
				//창제목 변경
				this.setTitle("Color: "+btnLabel[i]); //어떤 이벤트인지 설정22
			}
			
	}
	
	public static void main(String[] args) {
		new BtnArrayEvent7("배열이벤트 #7"); // 타이틀 설정 및 실행
	
	}

	
}
