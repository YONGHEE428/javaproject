package day0312;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class RadioCheck02  extends JFrame implements ActionListener, ItemListener{

	Container cp;
	JCheckBox cbDriverLic, cbBold;
	JCheckBox[] cbHobby = new JCheckBox[5];
	JButton btnHobby;
	JLabel lblResult;

	//생성자
	public RadioCheck02(String title) {
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
		cbDriverLic = new JCheckBox("운전면허");
		cbDriverLic.setBounds(50, 50, 100, 30);
		cbDriverLic.setOpaque(false); // 투명도
		cbDriverLic.addItemListener(this); // 아이템대상임을 표기
		this.add(cbDriverLic);
		
		//굵게 할지에 관한 체크박스
		cbBold = new JCheckBox("굵기 설정");
		cbBold.setBounds(50, 100, 100, 30);
		cbBold.setOpaque(false);
		cbBold.addItemListener(this);
		this.add(cbBold);
		
		int num = 50;
		String [] str = {"게임","배드민턴","수영","축구","자전거"};
		for(int i=0;i<cbHobby.length; i++) {
			cbHobby[i] = new JCheckBox(str[i]);
			cbHobby[i].setOpaque(false);
			cbHobby[i].setBounds(num, 200, 150, 50);
			this.add(cbHobby[i]);
			num += 150;
		}
		
		//결과라벨
		lblResult = new JLabel("안녕 체크앤 라디오 연습중이야~~~~",JLabel.CENTER);
		lblResult.setBounds(50, 250, 400, 100);
		lblResult.setBorder(new LineBorder(Color.pink, 5));
		this.add(lblResult);
		
		//버튼
		btnHobby = new JButton("나의 취미 알아보기");
		btnHobby.setBounds(500, 275, 200, 30);
		this.add(btnHobby);
		btnHobby.addActionListener(this);
	}
	//이벤트
	@Override
	public void itemStateChanged(ItemEvent e) {
		//체크박스 눌렀을떄 라벨 출력
		Object ob = e.getItem();
		
		if(ob == cbDriverLic) {
			if(cbDriverLic.isSelected()) {
				lblResult.setText("체크상태:"+cbDriverLic.isSelected()+", 난 면허가 있쩡");
			}else {
				lblResult.setText("체크상태:"+cbDriverLic.isSelected()+", 난 면허가 없쩡ㅜ");
			}
			
		}else if(ob == cbBold) {
			if(cbBold.isSelected())
				lblResult.setFont(new Font("",Font.BOLD,20));
			else
				lblResult.setFont(new Font("",Font.PLAIN,20));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = "나의 취미는 ";
		int n = 0;
		for(int i = 0; i <cbHobby.length; i++) {
			if(cbHobby[i].isSelected()) {
			msg += "["+cbHobby[i].getText() + "]   ";
			n++;
			}
		}
		msg += "이얌~!";
		if(n == 5)
			msg = "난 전부다 취미얌!!";
		else if(n ==0)
			msg = "난 취미가 없엉..";
		lblResult.setText(msg);
	}
	///////////////////////////////////////////////
	public static void main(String[] args) {
		new RadioCheck02("연습 #2");
	
	}
}
