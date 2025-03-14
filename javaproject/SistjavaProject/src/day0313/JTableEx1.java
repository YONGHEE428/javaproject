package day0313;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class JTableEx1  extends JFrame {

	Container cp;
	JTable tb1,tb2,tb3;
	JTextArea area; // 테이블의 내용을 출력할곳

	//생성자
	public JTableEx1(String title) {
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
		//2행2열의 그리드 레이아웃설정
		this.setLayout(new GridLayout(2, 2, 5, 5));
		
		//1번째 테이블_행열만 지정
		tb1=new JTable(5,4);
		this.add(new JScrollPane(tb1));
		
		//2번째 테이블은 생성시 데이타 넣기
		String [] title1 = {"사원명","나이","주소"};
		String [][] data1 = {
				{"김선아","22","부산시"},
				{"김윤아","34","대전시"},
				{"손흥민","35","대구시"}
				};
	
		tb2 = new JTable(data1, title1);
		this.add(new JScrollPane(tb2));
		
		//3번째 테이블은 Model을 이용해서 생성(나중에 추가,삭제 가능)
		DefaultTableModel model1 = new DefaultTableModel(data1,title1);
		tb3 = new JTable(model1);
		this.add(new JScrollPane(tb3));
		
		//추기_tb3는 모델을 이용해서 생성했으므로 가능
		String [] addData1 = {"박용희","25","ㅇ서울시"};
		model1.addRow(addData1);
	
		//이번엔 벡터로
		Vector<String> addData2 = new Vector<String>();
		addData2.add("조태민");
		addData2.add("26");
		addData2.add("서울시");
		model1.addRow(addData2);
		
		//출력공간 생성
		area = new JTextArea();
		this.add(new JScrollPane(area));
		
		//Jtable. Model 메서드 확인
		int colCount = tb3.getColumnCount();
		
		int rowCount1 = tb3.getRowCount();
		int rowCount2 = model1.getRowCount();
		
		area.append("tb3의 행개수: "+rowCount1+ "\n"); //5
		area.append("tb3의 행개수: "+rowCount2+ "\n");
		
		area.append("tb3의 열개수: "+colCount+ "\n"); //3
		
		area.append("1행1열의 값: " + tb3.getValueAt(1, 1) + "\n");
		area.append("3행2열의 값: " + tb3.getValueAt(3, 2) + "\n");
		area.append("1행1열의 값: " + model1.getValueAt(3, 2) + "\n");
		
		//tb3에 마우스클릭 이벤트를 추가해서 area 에출력
		tb3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				//클릭한 행번호 얻기
				int row = tb3.getSelectedRow();
				//클릭한 열번호 얻기
				int col = tb3.getSelectedColumn();
				
				//해당행,열에 있는 데이타를 얻어서 area에 출력
				area.append(row + "행 , "+col+"열 ==>"+tb3.getValueAt(row, col) + "\n");
				
				
			}
			
		});
		
	}
	//이벤트
	
	public static void main(String[] args) {
		new JTableEx1("연습 #3");
	
	}
}
