package day0312;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GraphicImage04  extends JFrame {

	Container cp;
	ImageIcon fileName1 = new ImageIcon("C:\\SIST0217\\자료들\\img3.gif");
	//생성자
	public GraphicImage04(String title) {
		super(title);
		
		//위치 너비
		this.setBounds(1100, 250, 800, 500);
		//색상
		cp = this.getContentPane();
		cp.setBackground(new Color(125,250,250));

		setDegign();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.gray);
		g.drawLine(20, 200, 300, 0);
		
		g.setColor(Color.black);
		g.drawOval(20, 80, 50, 50); // 테투리만 있는 원
		g.fillOval(100, 50, 100, 100); // 채워진 원
		
		g.setColor(Color.red);
		g.drawRect(200, 80, 50, 50); // 테두리 네모
		g.fillRect(200, 135, 50, 50); // 채원진 네모
		
		Image image = fileName1.getImage();
		g.drawImage(image, 80, 50, 500, 500,GraphicImage04.this);
		
		
	}
	//디자인
	public void setDegign() {
		
	}
	//이벤트
	
	public static void main(String[] args) {
		new GraphicImage04("연습 #4");
	
	}
}
