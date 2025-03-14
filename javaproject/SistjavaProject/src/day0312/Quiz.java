package day0312;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Quiz  extends JFrame implements ActionListener,ItemListener{

	Container cp;
	JCheckBox [] cb = new JCheckBox[6];
	JRadioButton [] rb1 = new JRadioButton[2];
	JRadioButton [] rb2 = new JRadioButton[5];
	Color [] color = {Color.red,Color.blue,Color.MAGENTA,Color.green,Color.orange};
	JLabel label;
 	
	//생성자
	public Quiz(String title) {
		super(title);
		
		//위치 너비
		this.setBounds(1100, 250, 800, 500);
		//색상
		cp = this.getContentPane();
		cp.setBackground(Color.white);

		setDegign();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//디자인
	public void setDegign() {
		this.setLayout(null);
		//남자여자
		int num = 50;
		String [] sung = {"남자","여자"};
		ButtonGroup bg = new ButtonGroup();
		for(int i = 0; i<rb1.length; i++) {
			rb1[i] = new JRadioButton(sung[i]);
			rb1[i].setOpaque(false);
			rb1[i].setBounds(10, num, 50, 50);
			bg.add(rb1[i]);
			this.add(rb1[i]);
			num+= 50;
			rb1[i].addActionListener(this);
		}
		//색상
		int num2 = 200;
		ButtonGroup bg2 = new ButtonGroup();
		String [] colorname = {"빨강","파랑","보랑","초록","주황"};
		for(int i = 0; i <rb2.length; i++) {
			rb2[i] = new JRadioButton(colorname[i]);
			rb2[i].setOpaque(false);
			rb2[i].setBounds(num2, 50, 50, 50);
			bg2.add(rb2[i]);
			this.add(rb2[i]);
			num2+=100;
			rb2[i].addActionListener(this);
		}
		//나라
		int num3 = 50;
		String [] country = {"미국","영국","일본","중국","독일","프랑스"};
		for(int i = 0; i < cb.length; i++) {
			cb[i] = new JCheckBox(country[i]);
			cb[i].setOpaque(false);
			cb[i].setBounds(num3, 400, 100, 50);
			this.add(cb[i]);
			num3+=120;
			cb[i].addItemListener(this);
			
		}
		label = new JLabel("이곳에서 출력이 됩니다.");
		label.setBounds(50, 150, 700, 200);
		label.setFont(new Font("고딕체",Font.PLAIN,28));
		label.setBorder(new LineBorder(Color.RED,2));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		this.add(label);
		
	}
	//이벤트
	@Override
	public void itemStateChanged(ItemEvent e) {
		//나라
		String msg = "내가 여행해본 나라는 ";
		int cnt = 0;
		for(int i = 0; i < cb.length; i++) {
			if(cb[i].isSelected() == true) {
				msg += cb[i].getText() + "  ";
				cnt++;
			}
		}
		if(cnt >0) {
			label.setFont(new Font("",Font.PLAIN,28));
			msg += "입니다.";
		}
		if (cnt > 4) {
			label.setFont(new Font("",Font.PLAIN,23));
		}
		if(cnt == 0) {
			msg = "나는 여행해본 나라가 없어요.";
		}
		label.setText(msg);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//남자여자
		Object ob = e.getSource();
		for(int i = 0; i < rb1.length; i++)
			if(ob == rb1[i]) {
				label.setText("저는 "+rb1[i].getText() + "입니다.");
			}

		//색갈
		for(int i = 0; i < rb2.length; i ++) {
			if(ob == rb2[i]) {
				label.setForeground(color[i]);
			}
		}
	}
	public static void main(String[] args) {
		new Quiz("연습 #3");
	
	}
}
