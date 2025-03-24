package day0321;

import java.awt.Color;
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import day0319.DBConnect;

public class SwingSawon  extends JFrame implements ActionListener, ItemListener{

   Container cp;
   JTable table;
   DefaultTableModel model;
   JTextArea area;
   JRadioButton [] rb = new JRadioButton [6];
   JButton btnAdd, btnDel;
   
   DBConnect db = new DBConnect();
   //생성자
   public SwingSawon(String title) {
      super(title);
      
      //위치 너비
      this.setBounds(1100, 250, 800, 500);
      //색상
      cp = this.getContentPane();
      cp.setBackground(Color.white);

      setDegign();
      
      //DB에서 가져온 테이블
      this.SawonTableSelect(1);
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   //디자인
   public void setDegign() {
      this.setLayout(null);
      
      //table 추가
      String [] title = {"번호","ID","사원명","성별","부서","월급"};
      model = new DefaultTableModel(title, 0); // 제목만 넣고 행 갯수 0
      table = new JTable(model);
      
      
      table.getColumnModel().getColumn(0).setPreferredWidth(10); //셀너비 조절 0 열
      table.getColumnModel().getColumn(1).setPreferredWidth(10);	// 1열의 셀너비 조절
      
      JScrollPane js = new JScrollPane(table);
      js.setBounds(10, 150, 760, 300);
      this.add(js);
      
      //라디오버튼 추가
      ButtonGroup bg = new ButtonGroup();
      //전체 남자 여자 홍보부 개발부 디자인부
      String [] rb_label = {"전체","남자","여자","홍보부","개발부","디자인부"};
      
      int xpox = 20;
      for(int i =0; i <rb.length; i++) {
    	  //라디오버튼 생성
    	  rb[i] = new JRadioButton(rb_label[i], i==0?true:false);
    	  rb[i].setBounds(xpox, 120, 80, 20);
    	  //rb[i].setBackground(Color.white);
    	  rb[i].setOpaque(false);
    	  rb[i].addItemListener(this);
    	  bg.add(rb[i]);
    	  this.add(rb[i]);
    	  xpox += 130;
      }
      
      //삭제버튼
      btnDel = new JButton("사원삭제");
      btnDel.setBounds(10, 10, 100, 30);
      btnDel.addActionListener(this);
      this.add(btnDel);
      
      //추가버튼
      btnAdd = new JButton("사원추가");
      btnAdd.setBounds(150,10,100,30);
      btnAdd.addActionListener(this);
      this.add(btnAdd);
   
   }
   
   //db데이타 가지고와서 테이블 추가
   //"전체","남자","여자","홍보부","개발부","디자인부"
   public void SawonTableSelect(int select) {
	   String sql = "";
	   
	   if(select == 1) 
		   sql = "select ROWNUM no,num id,name,gender,buseo,to_char(pay,'l999,999,999') pay from sawon ";
	   else if(select ==2)
		   sql = "select ROWNUM no,num id,name,gender,buseo,to_char(pay,'l999,999,999') pay from sawon where gender = '남자'";
	   else if(select==3)
		   sql = "select ROWNUM no,num id,name,gender,buseo,to_char(pay,'l999,999,999') pay from sawon where gender = '여자'";
	   else if(select==4)
		   sql = "select ROWNUM no,num id,name,gender,buseo,to_char(pay,'l999,999,999') pay from sawon where buseo = '홍보부'";
	   else if(select==5)
		   sql = "select ROWNUM no,num id,name,gender,buseo,to_char(pay,'l999,999,999') pay from sawon where buseo = '개발부'";
	   else if(select==6)
		   sql = "select ROWNUM no,num id,name,gender,buseo,to_char(pay,'l999,999,999') pay from sawon where buseo = '디자인부'";
	   
	   Connection co = db.getConnection();
	   PreparedStatement pst = null;
	   ResultSet re = null;
	   
	   try {
		pst = co.prepareStatement(sql);
		re = pst.executeQuery();
		
		//기존의 데이타 삭제후 가져오기
		model.setRowCount(0);
		while(re.next()) {
			//테이블에 추가할 벡터 선언후 데이터 추가
			Vector<String> data = new Vector<String>();
			data.add(re.getString("no"));
			data.add(re.getString("id"));
			data.add(re.getString("name"));
			data.add(re.getString("gender"));
			data.add(re.getString("buseo"));
			data.add(re.getString("pay"));
			
			//벡터의 데이타를 행으로 추가
			model.addRow(data);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		db.dbClose(re, pst, co);
	}
   }
   
   
   //이벤트
   @Override
   public void itemStateChanged(ItemEvent e) {
	   //라디오버튼 제어
	   for(int i =0; i <rb.length; i++) {
		   if(rb[i].isSelected() == true)
			   SawonTableSelect(i+1);
	   }
	   /*Object ob = e.getSource();
		for(int i = 0; i < rb.length; i++)
			if(ob == rb[i]) {
				SawonTableSelect(i+1);;
			}*/
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	   //추가버튼,삭제버튼
	   Object ob = e.getSource();
	   Connection co = db.getConnection();
	   PreparedStatement pst = null;
	   String sql = "";
	   
	   if(ob == btnAdd) {
	        String name = JOptionPane.showInputDialog("사원명을 입력해주세요");
	        // 만약 '취소'가 눌러졌다면 null을 반환하므로 이를 체크
	        if (name == null || name.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "사원명을 입력해주세요.");
	            return; // 빈값이거나 취소가 눌렸으면 아무 것도 하지 않고 리턴
	        }
	        
	        String gender = JOptionPane.showInputDialog("성별을 입력해주세요 : ");
	        if (!gender.equals("남자") && !gender.equals("여자")) {
	            JOptionPane.showMessageDialog(this, "성별을 올바르게 입력해주세요.");
	            return;
	        }
	        
	        String buseo = JOptionPane.showInputDialog("부서를 입력해주세요 : ");
	        if (!buseo.equals("홍보부") && !buseo.equals("디자인부") && !buseo.equals("개발부")) {
	            JOptionPane.showMessageDialog(this, "부서를 입력해주세요.");
	            return;
	        }
	        
	        String pay = JOptionPane.showInputDialog("급여를 입력해주세요 : ");
	        if (pay == null || pay.trim().isEmpty()) {
	            JOptionPane.showMessageDialog(this, "급여를 입력해주세요.");
	            return;
	        }
			   sql = "insert into sawon values(seq_sawon.nextval,?,?,?,?)";
		   
		   try {
			pst=co.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, gender);
			pst.setString(3, buseo);
			pst.setString(4, pay);
			
			pst.executeUpdate();
			
			//테이블 다시호출
			this.SawonTableSelect(1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			db.dbClose(pst, co);
		   }
	   }else if(ob == btnDel) {
		   // 선택된 행 가져오기
	        int selectedRow = table.getSelectedRow();

	        // 행이 선택되지 않았으면
	        if (selectedRow == -1) {
	            JOptionPane.showMessageDialog(this, "삭제할 행을 선택해주세요");
	            return;
	        }

	       String numToDelete = model.getValueAt(selectedRow, 1).toString();
		   sql = "delete sawon where num = ?";
		   
		   try {
			pst = co.prepareStatement(sql);
	        pst.setString(1, numToDelete);  
			pst.executeUpdate();
			
	        // 테이블에서 해당 행 삭제
	        model.removeRow(selectedRow);
			this.SawonTableSelect(1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			db.dbClose(pst, co);
		}
	   }
   }
   
   
   public static void main(String[] args) {
      new SwingSawon("연습 #3");
   
   }


}
