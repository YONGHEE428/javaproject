package day0310;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingIcon5 extends JFrame implements ActionListener{

	Container cp;
	JButton btn1,btn2,btn3,btn4;
	
	//각각의 아이콘
	ImageIcon icon1 = new ImageIcon("C:\\SIST0217\\자료들\\img1.gif");
	ImageIcon icon2 = new ImageIcon("C:\\SIST0217\\자료들\\img_msn_i10.gif");
	ImageIcon icon3 = new ImageIcon("C:\\SIST0217\\자료들\\ame9.gif");
	ImageIcon icon4 = new ImageIcon("C:\\SIST0217\\자료들\\an07.gif");

	
	//생성자
	public SwingIcon5(String title) {
		super(title);
		
		//위치 너비
		this.setBounds(800, 250, 300, 500);
		//색상
		cp = this.getContentPane();
		cp.setBackground(new Color(102,120,0));

		setDegign();
		
		this.setVisible(true);
	}
	
	//디자인
	public void setDegign() {
		this.setLayout(new GridLayout(2,2));
		
		btn1 = new JButton("버튼 1",icon1);
		btn2 = new JButton("버튼 2",icon2);
		btn3 = new JButton("버튼 3",icon3);
		btn4 = new JButton("버튼 4",icon4);
		
		/*btn1.setBackground(Color.pink);
		btn2.setBackground(Color.yellow);
		btn3.setBackground(Color.green);
		btn4.setBackground(Color.blue);
		btn4.setForeground(Color.white);*/
		this.add(btn1);
		this.add(btn2);
		this.add(btn3);
		this.add(btn4);
		
		btn1.setHorizontalTextPosition(JButton.CENTER); //왼쪽 오른쪽 가운대
		btn1.setVerticalTextPosition(JButton.BOTTOM); //위 아래 가운대
		
		//이벤트
		btn1.setPressedIcon(icon3);
		btn1.setRolloverIcon(icon2);
		btn1.addActionListener(this);
	}
	//이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == btn1)
			JOptionPane.showMessageDialog(this,"하이");
	}
	
	public static void main(String[] args) {
		new SwingIcon5("스윙레이아웃 연습 #3");
	
	}

	
}
