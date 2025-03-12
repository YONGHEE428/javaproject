package day0310;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingBtnEvent4 extends JFrame implements ActionListener {

	Container cp;
	JButton btn1, btn2;
	
	//생성자
	public SwingBtnEvent4(String title) {
		super(title);
		
		//위치 너비
		this.setBounds(800, 250, 300, 500);
		//색상
		cp = this.getContentPane();
		cp.setBackground(new Color(125,250,120));

		setDegign();
		
		this.setVisible(true);
	}
	
	//디자인
	public void setDegign() {
		this.setLayout(new FlowLayout());
		btn1 = new JButton("←");
		btn2 = new JButton("→");
		
		btn1.setBackground(Color.yellow);
		btn2.setBackground(Color.lightGray);
		
		this.add(btn1);
		this.add(btn2);
		
		btn1.addActionListener(this);//이벤트 설정한것을 불러오기 위한 명령어
		btn2.addActionListener(this);
	}
	//이벤트 설정 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		
		if(ob == btn1)
			JOptionPane.showMessageDialog(this, "왼쪽입니다");
		else if(ob == btn2)
			JOptionPane.showMessageDialog(this, "오른쪽입니다.");
	}
	
	public static void main(String[] args) {
		new SwingBtnEvent4("스윙 버튼이벤트 #4");
	
	}

	
}
