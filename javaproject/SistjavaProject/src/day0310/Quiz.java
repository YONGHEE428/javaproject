package day0310;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Quiz extends JFrame implements ActionListener {

	Container cp;
	JLabel result,nul1, nul2;
	JTextField text1, text2;
	JButton b1,b2,b3,b4;
	//생성자
	public Quiz(String title) {
		super(title);
		
		//위치 너비
		this.setBounds(1600, 250, 300, 500);
		//색상
		cp = this.getContentPane();
		cp.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDegign();
		
		this.setVisible(true);
	}
	
	//디자인
	public void setDegign() {
		this.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,128,128));
		panel.setBounds(0,0,285,50);
		this.add(panel);
		JLabel label = new JLabel("사칙연산프로그램");
		label.setFont(new Font("",Font.BOLD ,20));
		label.setForeground(Color.white);
		panel.add(label);
		
		nul1 = new JLabel("숫자1: ");
		nul1.setForeground(Color.gray);
		nul1.setBounds(0,60,80,50);
		this.add(nul1);
		nul2 = new JLabel("숫자2: ");
		nul2.setForeground(Color.gray);
		nul2.setBounds(0,115,80,50);
		this.add(nul2);
		
		text1 = new JTextField();
		text1.setBounds(40,60,240,50);
		text1.setFont(new Font("",Font.ITALIC,20));
		this.add(text1);
		text2 = new JTextField();
		text2.setBounds(40,115,240,50);
		text2.setFont(new Font("",Font.ITALIC,20));
		this.add(text2);
		
		b1 = new JButton("더하기");
		b2 = new JButton("빼기");
		b3 = new JButton("곱하기");
		b4 = new JButton("나누기");
		
		b1.setBounds(5,180,275,30);
		this.add(b1);
		b2.setBounds(5,225,275,30);
		this.add(b2);
		b3.setBounds(5,270,275,30);
		this.add(b3);
		b4.setBounds(5,315,275,30);
		this.add(b4);
		
		result = new JLabel("계산결과:");
		result.setBounds(0,350,275,100);
		result.setFont(new Font("",Font.BOLD,20));
		result.setForeground(Color.red);
		this.add(result);
		
		//이벤트 호출
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}
	//이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		if(ob == b1) {
			int a = Integer.parseInt(text1.getText().trim());
			int b = Integer.parseInt(text2.getText().trim());
			int num = a + b;
			String s = "계산결과: " + a + " + " + b + " = " + num;
			result.setText(s);
		}
		else if(ob == b2) {
			int a = Integer.parseInt(text1.getText().trim());
			int b = Integer.parseInt(text2.getText().trim());
			int num = a - b;
			String s = "계산결과: " + a + " - " + b + " = " + num;
			result.setText(s);
		}
		else if(ob == b3) {
			int a = Integer.parseInt(text1.getText().trim());
			int b = Integer.parseInt(text2.getText().trim());
			int num = a * b;
			String s = "계산결과: " + a + " * " + b + " = " + num;
			result.setText(s);
		}
		else if(ob == b4) {
			int a = Integer.parseInt(text1.getText().trim());
			int b = Integer.parseInt(text2.getText().trim());
			int num = a / b;
			String s = "계산결과: " + a + " / " + b + " = " + num;
			result.setText(s);
		}
	}
	///////////////////////////////////
	public static void main(String[] args) {
		new Quiz("계산기프로그램");
	
	}
}
