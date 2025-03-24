package day0324;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import day0319.DBConnect;

public class SwingScoreDB  extends JFrame implements ActionListener{

   Container cp;
   JTextArea area;
   JButton btnInsert, btnUpdate, btnDel;
   JTable table;
   DBConnect db = new DBConnect();
   DefaultTableModel model;
   InsertScore insert = new InsertScore("성적추가폼");
   UpdateScore update = new UpdateScore("성적수정폼");
   //생성자
   public SwingScoreDB(String title) {
      super(title);
      
      //위치 너비
      this.setBounds(1100, 250, 800, 600);
      //색상
      cp = this.getContentPane();
      cp.setBackground(new Color(125,250,250));

      setDegign();
     
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   //디자인
   public void setDegign() {
     // this.setLayout(null);
     
      String [] title = {"번호","이름","반","Java","Jsp","Spring","종점","합계"};
      JPanel pTop = new JPanel();
      this.add("North",pTop);
      
      model = new DefaultTableModel(title,0);
      table = new JTable(model);
      this.add("Center",new JScrollPane(table));
      
      selectTableWrite();
      
      btnInsert = new JButton("성적추가");
      btnInsert.addActionListener(this);
      pTop.add(btnInsert);
      
      btnDel = new JButton("성적삭제");
      btnDel.addActionListener(this);
      pTop.add(btnDel);
      
      btnUpdate = new JButton("성적수정");
      btnUpdate.addActionListener(this);
      pTop.add(btnUpdate);
      
      //Insertscore에 있는 추가버튼에 이벤트 주기
      //updatescore에 있는 수정버튼에 이벤트 주기
      insert.btnAdd.addActionListener(this);
      update.btnupd.addActionListener(this);
      
      
      
   }
  
   ////////////////////////////////////////////////////////////////////테이블 출력 메서드
   public void selectTableWrite() {
	   model.setRowCount(0);
	   
	   Connection co = db.getConnection();
	   PreparedStatement pst = null;
	   ResultSet re = null;
	   
	   String sql = "select * from stuscore order by num";
	   
	   try {
		pst = co.prepareStatement(sql);
		re = pst.executeQuery();
		
		while (re.next()) {
			Vector<String> data = new Vector<String>();
			data.add(re.getString("num"));
			data.add(re.getString("name"));
			data.add(re.getString("ban"));
			data.add(re.getString("Java"));
			data.add(re.getString("Jsp"));
			data.add(re.getString("Spring"));
			data.add(re.getString("Total"));
			data.add(re.getString("Average"));
			
			model.addRow(data);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		db.dbClose(re, pst, co);
	}	   
   }
  
   
   
   
   ////////////////////////////////////////////////////////////////////
   public void insertsocredta() {
	    String name = insert.TfName.getText().trim();  // trim()으로 공백을 제거
	    String java = insert.TfJave.getText().trim();
	    String jsp = insert.TfJsp.getText().trim();
	    String spring = insert.TfSpring.getText().trim();
	    String ban = (String) insert.CbBan.getSelectedItem();

	    // 빈 값이 있으면 처리
	    if (name.isEmpty() || java.isEmpty() || jsp.isEmpty() || spring.isEmpty()) {
	        System.out.println("모든 필드를 입력해야 합니다.");
	        return;  // 빈 필드가 있으면 종료
	    }

	    // 숫자 입력 확인
	    int javaScore = 0, jspScore = 0, springScore = 0;

	    try {
	        javaScore = Integer.parseInt(java);  // 숫자 변환 시 오류 처리
	        jspScore = Integer.parseInt(jsp);
	        springScore = Integer.parseInt(spring);
	    } catch (NumberFormatException e) {
	        System.out.println("성적은 숫자만 입력 가능합니다.");
	        return;  // 숫자가 아닐 경우 종료
	    }

	    // 총점 및 평균 계산
	    int total = javaScore + jspScore + springScore;
	    double average = total / 3.0;

	    String sql = "INSERT INTO stuscore VALUES(seq_sungjuk.nextval,?,?,?,?,?,?,?)";

	    Connection co = db.getConnection();
	    PreparedStatement pst = null;
	    try {
	        pst = co.prepareStatement(sql);

	        // 순서대로 바인딩
	        pst.setString(1, name);
	        pst.setString(2, java);
	        pst.setString(3, jsp);
	        pst.setString(4, spring);
	        pst.setInt(5, total);
	        pst.setDouble(6, average);
	        pst.setString(7, ban);

	        pst.executeUpdate();
	        System.out.println("성적이 성공적으로 추가되었습니다.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(pst, co);
	    }
	}
   ///////////////////////////////////////////////////////////////////////////////////
   public void UpdateScore() {

	    String name = update.TfName.getText().trim();  // 공백 제거
	    String java = update.TfJave.getText().trim();
	    String jsp = update.TfJsp.getText().trim();
	    String spring = update.TfSpring.getText().trim();
	    String ban = (String) update.CbBan.getSelectedItem();

	    // 빈 값이 있으면 처리
	    if (name.isEmpty() || java.isEmpty() || jsp.isEmpty() || spring.isEmpty()) {
	        System.out.println("모든 필드를 입력해야 합니다.");
	        return;  // 빈 필드가 있으면 종료
	    }

	    // 숫자 입력 확인
	    int javaScore = 0, jspScore = 0, springScore = 0;

	    try {
	        javaScore = Integer.parseInt(java);  // 숫자 변환 시 오류 처리
	        jspScore = Integer.parseInt(jsp);
	        springScore = Integer.parseInt(spring);
	    } catch (NumberFormatException e) {
	        System.out.println("성적은 숫자만 입력 가능합니다.");
	        return;  // 숫자가 아닐 경우 종료
	    }

	    // 총점 및 평균 계산
	    int total = javaScore + jspScore + springScore;
	    double average = total / 3.0;

	    // 수정할 데이터가 있는 테이블의 해당 행 번호 가져오기
	    int selectedRow = table.getSelectedRow();
	    int num = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());

	    String sql = "update stuscore set name = ?, java = ?, jsp = ?, spring = ?, total = ?, average = ?, ban = ? where num = ?";

	    Connection co = db.getConnection();
	    PreparedStatement pst = null;

	    try {
	        pst = co.prepareStatement(sql);

	        // 순서대로 바인딩
	        pst.setString(1, name);
	        pst.setString(2, java);
	        pst.setString(3, jsp);
	        pst.setString(4, spring);
	        pst.setInt(5, total);
	        pst.setDouble(6, average);
	        pst.setString(7, ban);
	        pst.setInt(8, num);  // 수정할 레코드의 'num' 값을 조건으로 사용

	        pst.executeUpdate();
	        System.out.println("성적이 성공적으로 수정되었습니다.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        db.dbClose(pst, co);
	    }
	}
   public void DeleteScore() {
	   Connection co = db.getConnection();
	   PreparedStatement pst = null;
	   
	   int selectedRow = table.getSelectedRow();
	   int num = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
	   
	   String sql = "delete from stuscore where num = ?";
	   try {
		pst = co.prepareStatement(sql);
		
		pst.setInt(1, num);
		pst.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		db.dbClose(pst, co);
	}
	   
   }
   
   //이벤트
   @Override
   public void actionPerformed(ActionEvent e) {
	   Object ob = e.getSource();
	   
	   if(ob == btnInsert) {
		   System.out.println("add");
		  // InsertScore insert = new InsertScore("성적추가폼");
		  insert.setVisible(true);
	   }
	   else if(ob == insert.btnAdd) {
		   insertsocredta();
		   //테이블 다시 출력	
		   
		   this.selectTableWrite();
		   	
		   //초기화
		   insert.TfName.setText("");
		   insert.TfJave.setText("");
		   insert.TfJsp.setText("");
		   insert.TfSpring.setText("");
		   
		   //프레임 사라지게
		   insert.setVisible(false);
	   }
	   
	   else if( ob == btnDel) {
		   System.out.println("Del");
		   int selectedRow = table.getSelectedRow();
	        // 행이 선택되지 않으면 수정 화면을 띄우지 않음
	        if (selectedRow == -1) {
	            JOptionPane.showMessageDialog(this, "수정할 행을 선택하여 주세요");
	            return;  // 선택된 행이 없으면 수정 화면을 띄우지 않음
	        }
	       
	        DeleteScore();
	        this.selectTableWrite();
	        JOptionPane.showMessageDialog(this, "삭제가 완료되었습니다.");
	   }

	   else if(ob ==btnUpdate) {
		   System.out.println("Update");
		   int selectedRow = table.getSelectedRow();
	        // 행이 선택되지 않으면 수정 화면을 띄우지 않음
	        if (selectedRow == -1) {
	            JOptionPane.showMessageDialog(this, "수정할 행을 선택하여 주세요");
	            return;  // 선택된 행이 없으면 수정 화면을 띄우지 않음
	        }
	       update.TfName.setText((String) table.getValueAt(selectedRow, 1));
	       update.TfJave.setText((String) table.getValueAt(selectedRow, 3));
	       update.TfJsp.setText((String) table.getValueAt(selectedRow, 4));
	       update.TfSpring.setText((String) table.getValueAt(selectedRow, 5));
	       update.CbBan.setSelectedItem((String) table.getValueAt(selectedRow, 2));
		   update.setVisible(true);
		   
	   }
	   else if(ob ==update.btnupd) {
		   System.out.println("수정버튼");
		   
		   UpdateScore();
		   
		   this.selectTableWrite();
		   //초기화
		   update.TfName.setText("");
		   update.TfJave.setText("");
		   update.TfJsp.setText("");
		   update.TfSpring.setText("");
		   
		   //프레임 사라지게
		   update.setVisible(false);
	   }
	  
	   
   }
   public static void main(String[] args) {
      new SwingScoreDB("");
   
   }


}
