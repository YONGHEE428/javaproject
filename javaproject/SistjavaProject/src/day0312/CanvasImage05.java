package day0312;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CanvasImage05  extends JFrame {

	Container cp;
	JButton btnImage;
	Image image;
	Mycanvas mycan; //캔버스를 상속받은 내부클래스
	
	//생성자
	public CanvasImage05(String title) {
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
	
	//디자인
	public void setDegign() {
		this.setLayout(null);
		
		image = new ImageIcon("C:\\SIST0217\\자료들\\45-pandadog.gif").getImage();
		mycan = new Mycanvas(); //paint메서드 자동호출
		mycan.setBounds(300, 50, 800, 800);
		this.add(mycan);
		
		//버튼
		btnImage = new JButton("이미지 불러오기");
		btnImage.setBounds(20,500,200,50);
		this.add(btnImage);
		
		//익명내부클래스
		
		btnImage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//취소시 메서드 종료
				FileDialog dlg = new FileDialog(CanvasImage05.this,"이미지 가져오기",FileDialog.LOAD);
				dlg.setVisible(true);
				
				if(dlg.getDirectory() ==null)
					return;
				
				String imagefileName = dlg.getDirectory() + dlg.getFile();
				
				//Image생성
				image = new ImageIcon(imagefileName).getImage();
				//캔버스크래스의 paint메서드 호출
				mycan.repaint();
			}
		});
		
	}
	
	//canvas를 상속받는 클래스
	class Mycanvas extends Canvas{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			//이미지출력
			g.drawImage(image, 30, 30,100,100 ,this);
		}
	}
	//이벤트
	
	public static void main(String[] args) {
		new CanvasImage05("연습 #5");
	
	}
}
