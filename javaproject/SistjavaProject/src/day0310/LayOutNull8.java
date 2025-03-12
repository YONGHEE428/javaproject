package day0310;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

//두개의 라벨과 텍스트필드 그리고 버튼을 만든후
//각각 숫자를 넣고 버튼을 클릭하면 라벨에 22+44=66
public class LayOutNull8 extends JFrame implements ActionListener{

	Container cp; // 이벤트 창
	JLabel lblResult, lblnum1, lblnum2; // 라벨
	JTextField tfSu1, tfSu2; // 텍스트 입력받을 필드
	JButton btnAdd; // 이벤트시킬 버튼
	
	//생성자
	public LayOutNull8(String title) {
		super(title);
		
		//위치 너비
		this.setBounds(650, 200, 700, 700);
		//색상
		cp = this.getContentPane();
		cp.setBackground(new Color(125,250,250));

		setDegign();
		
		this.setVisible(true);
	}
	
	//디자인
	public void setDegign() {
		//기본레이아웃 없애고 직접 지정
		this.setLayout(null);
		lblnum1 = new JLabel("숫자1:");
		lblnum2 = new JLabel("숫자2:");
		
		lblnum1.setBounds(120,100,80,50);
		this.add(lblnum1);
		lblnum2.setBounds(120,300,80,50);
		this.add(lblnum2);
		
		tfSu1 = new JTextField();
		tfSu1.setBounds(160,100,100,50);
		this.add(tfSu1);
		tfSu2 = new JTextField();
		tfSu2.setBounds(160,300,100,50);
		this.add(tfSu2);
		
		btnAdd = new JButton("숫자더하기");
		btnAdd.setBounds(300,200,200,50);
		this.add(btnAdd);
		
		//결과 나오는곳
		lblResult = new JLabel("결과 나오는곳");
		lblResult.setBounds(100,500,200,50);
		lblResult.setBorder(new TitledBorder("결과확인"));
		lblResult.setFont(new Font("",Font.BOLD,30));
		this.add(lblResult);

		
		btnAdd.addActionListener(this);
	}
	//이벤트
	@Override
	public void actionPerformed(ActionEvent e) {

		int su1 = Integer.parseInt(tfSu1.getText().trim());
		int su2 = Integer.parseInt(tfSu2.getText().trim());
		int tot = su1 + su2;
		String s = su1 + " + " + su2 + " = " + tot;
		lblResult.setText(s);
		int a = (int)(Math.random()*225);
		int b = (int)(Math.random()*225);
		int c = (int)(Math.random()*225);
		cp.setBackground(new Color(a,b,c));
		
	}

	public static void main(String[] args) {
		new LayOutNull8("스윙레이아웃 연습 #3");
	
	}

}	
