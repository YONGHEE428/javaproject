package day0312;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.classfile.AccessFlags;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class RadioCheck01  extends JFrame implements ActionListener{

	Container cp;
	JRadioButton [] rb = new JRadioButton[4]; // 하나만 선택하고 싶을때
	JCheckBox [] cb = new JCheckBox[5]; // 다중선택가능
	JLabel lblMessage;
	Color [] colors = {Color.red,Color.blue,Color.green,Color.pink};
	
	
	
	//생성자
	public RadioCheck01(String title) {
		super(title);
		
		//위치 너비
		this.setBounds(600, 250, 800, 500);
		//색상
		cp = this.getContentPane();
		cp.setBackground(new Color(100,150,50));

		setDegign();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//디자인
	public void setDegign() {
		String [] str1 = {"빨간색","파란색","초록색","핑크색"};
		JPanel pTop = new JPanel();
		pTop.setBorder(new TitledBorder("글자색선택"));
		this.add("North",pTop);
		
		//버튼 하나만 선택되도록
		ButtonGroup bg = new ButtonGroup();
		
		for(int i=0;i<rb.length;i++) {
			rb[i] = new JRadioButton(str1[i], i==0?true:false); // 라디오 버튼 생성
			pTop.add(rb[i]);
			bg.add(rb[i]);
			
			rb[i].addActionListener(this); // 버튼에 액션추가
		}
		//결과출력
		ImageIcon icon = new ImageIcon("C:\\SIST0217\\자료들\\45-pandadog.gif");
		lblMessage = new JLabel("아령하세요",icon,JLabel.CENTER);
		lblMessage.setHorizontalTextPosition(JLabel.LEFT);
		lblMessage.setBorder(new LineBorder(Color.red,2));//라인굵기
		this.add(lblMessage);
		
		//하단패널에 보더로 감싼 5개의 checkbox버튼 만들기
		JPanel pBottom = new JPanel();
		pBottom.setBorder(new TitledBorder("가능한 컴퓨터언어는"));
		this.add("South",pBottom);
		String [] str2 = {"Java", "Html","Jsp","Ajex","Spring"}; 
		for(int i=0;i<cb.length;i++){
			cb[i] = new JCheckBox(str2[i]);
			pBottom.add(cb[i]);	
			cb[i].addActionListener(this);
		}
	}
	//이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		//라디오버튼 처리,메세지 컬러별로 출력
		for(int i = 0; i < rb.length; i++) {
			if(ob == rb[i]) {
				lblMessage.setFont(new Font("",Font.BOLD,20));
				lblMessage.setForeground(colors[i]);
			}
		}
		
		//체크박스 호출처리,선택한 체크박스의 메세지별 출력
		String msg = "나의 가능한 컴퓨터 언어는  ";
		boolean bo = false;
		for(int i = 0; i < cb.length; i++) {
			if(cb[i].isSelected() == true) {
				msg += cb[i].getText()+ "    ";
				bo = true; // 체크박스 하나라도 체크되었으면 트루
			}
		}
		if(!bo) // 체크박스 하나도 체크 안되어있을시
			msg = "아령하세요";
		lblMessage.setText(msg);
		
	}
	///////////////////////////////////////////////////
	public static void main(String[] args) {
		new RadioCheck01("스윙 Radio&Check #1");
	
	}

	
}
