package day0313;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import day0220.SubStringTest_06;

public class JTbaleIPgo  extends JFrame implements ActionListener {

	Container cp;
	JTextField name, pay,cnt;
	JTextArea area;
	DefaultTableModel model;
	JTable jt;
	JButton add, del;
	
	static final String FILENAME = "C:\\SIST0217\\work\\sangipgo.txt";
	
	//생성자
	public JTbaleIPgo(String title) {
		super(title);
		
		//위치 너비
		this.setBounds(1100, 250, 800, 500);
		//색상
		cp = this.getContentPane();
		cp.setBackground(new Color(125,250,250));

		setDegign();
		//테이블을 생성후 파일데이터 추가
		tableDataRead();
		//종료시 테이블데이타 저장
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				//저장 메서드
				tableDataSave();
			}
		});

		this.setVisible(true);
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//저장시 딸기:3:1000:3000
	public void tableDataSave() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME);
			for(int i = 0; i<jt.getRowCount(); i++) { //행
				String s = ""; //저장할 문장 초기화
				for(int j =0; j < jt.getColumnCount(); j++) { //열
					s+=jt.getValueAt(i, j)+":"; // s == 0행0열 + 0행1열 +0행 2열~~
				}
				s=s.substring(0,s.length()-1); //:제거
				fw.write(s + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//처음생성시 테이블에 불러올 메서드
	public void tableDataRead() {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			while(true) {
				String s = br.readLine();
				if(s == null)
					break;
				
				String [] data = s.split(":");
				//table에 배열형 데이터 추가
				model.addRow(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
		}finally {
			try {
				if(br!=null) br.close();
				if(fr!=null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//디자인
	public void setDegign() {
		this.setLayout(null);
		
		//상품이름
		name = new JTextField();
		name.setBorder(new TitledBorder("상품이름"));
		name.setFont(new Font("",Font.BOLD,20));
		name.setBounds(20, 20, 150, 50);
		this.add(name);
		//상품 단가
		pay = new JTextField();
		pay.setBorder(new TitledBorder("상품단가"));
		pay.setFont(new Font("",Font.BOLD,20));
		pay.setBounds(610, 20, 150, 50);
		this.add(pay);
		//상품 개수
		cnt = new JTextField();
		cnt.setBorder(new TitledBorder("상품개수"));
		cnt.setFont(new Font("",Font.BOLD,20));
		cnt.setBounds(320, 20, 150, 50);
		this.add(cnt);
		
		//추가 삭제 버튼
		add = new JButton("추가하기");
		add.setBounds(100, 100, 150, 50);
		this.add(add);
		
		del = new JButton("삭제하기");
		del.setBounds(510, 100, 150, 50);
		this.add(del);
		
		//버튼 2개에 이벤트 추가
		add.addActionListener(this);
		del.addActionListener(this);
		//테이블
		String [] title = {"상품명","입고수량","입고단가","총금액"};
		model = new DefaultTableModel(title,0); // 0은 행갯수
		jt=new JTable(model);
		// JScrollPane에 JTable을 추가
        JScrollPane js = new JScrollPane(jt);
        js.setBounds(20, 200, 745, 245); 
        this.add(js);
	
        //테이블 클릭시 선택한 행번호를 selectRow에 저장
       /* jt.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		super.mouseClicked(e);
        		int selectrow = jt.getSelectedRow(); //행번호 저장
        	}
        });*/
	}
	//이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == add) {
			String sang = name.getText().trim();
			String su = cnt.getText().trim();
			String dan = pay.getText().trim();
			
			if(sang.length() == 0 || su.length() == 0 || dan.length() == 0) {
				JOptionPane.showMessageDialog(this, "3개의 값을 모두 입력해주세요");
				return;
			}
			
			int total = Integer.parseInt(su) * Integer.parseInt(dan);
			NumberFormat nf = NumberFormat.getInstance();
			Vector<String> data = new Vector<String>();
			data.add(sang);
			data.add(su);
			data.add(dan);
			data.add(nf.format(total));
			
			//테이블에 추가
			model.addRow(data);
			//입력값 초기화
			name.setText("");
			cnt.setText("");
			pay.setText("");
			
			tableDataSave();
		}
		else if (ob == del) {
	        // 선택된 행 가져오기
	        int selectedRow = jt.getSelectedRow();

	        // 행이 선택되지 않았으면
	        if (selectedRow == -1) {
	            JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요");
	            return;
	        }

	        // 테이블에서 해당 행 삭제
	        model.removeRow(selectedRow);

	        // 파일에 데이터 저장 (삭제 후)
	        tableDataSave();
	    }
		
	}
	public static void main(String[] args) {
		new JTbaleIPgo("연습 #3");
	
	}

}
