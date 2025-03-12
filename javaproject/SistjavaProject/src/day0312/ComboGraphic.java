package day0312;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboGraphic  extends JFrame {

	Container cp;
	JComboBox<String> combo;
	String [] items = {"선","원","사각형","이미지","문자열"};
	int index = 3; //이미지를 기본값으로 설정
	ComboDraw draw;
	
	static final String ImageName = "C:\\SIST0217\\자료들\\ironman.jpg";
	
	//생성자
	public ComboGraphic(String title) {
		super(title);
		
		//위치 너비
		this.setBounds(1000, 150, 800, 800);
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
		
		combo = new JComboBox<String>(items);
		combo.setBounds(40, 50, 100, 30);
		combo.setSelectedIndex(index); //초기값 설정
		this.add(combo);
		
	
		
		
		//콤보박스 선택시 이벤트 
		combo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				index = combo.getSelectedIndex();
				draw.repaint();
				
			}
		});
		draw = new ComboDraw();
		draw.setBounds(30, 60, 700, 700);
		this.add(draw);
		
	}
	
	//랜덤하게 구해서 Color타입으로 반환하는 메서드
	public Color getRandomColor() {
		int r =(int)(Math.random()*256);
		int g =(int)(Math.random()*256);
		int b =(int)(Math.random()*256);
		return new Color(r,g,b);
	}
	class ComboDraw extends Canvas{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			
			Image image = null;
			Color color = null;
			
			int x1=0,x2=0,y1=0,y2=0;
			
			switch(index) {
			case 0://선
				for(int i=1;i<=20;i++) {
					color=getRandomColor();
					g.setColor(color);
					
					x1 =(int)(Math.random()*200)+150;
					x2 =(int)(Math.random()*300)+100;
					y1 =(int)(Math.random()*500);
					y2 =(int)(Math.random()*500);
					g.drawLine(x1, x2, y1, y2);
				}
				break;
			case 1: //원
				for(int i=1; i<=20;i++) {
					color=getRandomColor();
					g.setColor(color);
					
					x1 =(int)(Math.random()*200)+150;
					x2 =(int)(Math.random()*300)+100;
					
					g.fillOval(x1, x2, 50, 50);
				}
				break;
			case 2 : //사각형 
				for(int i=1; i<=20;i++) {
					color=getRandomColor();
					g.setColor(color);
					
					x1 =(int)(Math.random()*200)+150;
					x2 =(int)(Math.random()*300)+100;
					
					g.fillRect(x1, x2, 50, 50);
				}
				break;
			case 3 : //이미지
				image = new ImageIcon(ImageName).getImage();
				x1 =(int)(Math.random()*200)+150;
				x2 =(int)(Math.random()*300)+100;
				g.drawImage(image, x1,x2,this);
				/*FileDialog dlg = new FileDialog(ComboGraphic.this,"",FileDialog.LOAD);
				dlg.setVisible(true);
				
				if(dlg.getDirectory() == null)
					return;
				
				String imgname = dlg.getDirectory()+dlg.getFile();
				image = new ImageIcon(imgname).getImage();
				x1 =(int)(Math.random()*200)+150;
				x2 =(int)(Math.random()*300)+100;
				g.drawImage(image, x1,x2,this);
				repaint();*/
				break;
			case 4 : //문자열
				g.setFont(new Font("궁서체",Font.BOLD,23));
				
				for(int i=1; i<=10; i++) {
					color=getRandomColor();
					g.setColor(color);
					
					x1 =(int)(Math.random()*200)+150;
					x2 =(int)(Math.random()*300)+100;
					g.drawString("Hello", x1, x2);
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					repaint();
				}
				break;
			}
			
		}
		
	}
	//이벤트
	
	public static void main(String[] args) {
		new ComboGraphic("콤보박스로 그래픽 나타내기 #6");
	
	}
}
