package Movie;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
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
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import day0319.DBConnect;

public class Moviemain  extends JFrame implements ActionListener,ItemListener{

   Container cp;
   JTextArea area;
   JButton btnAdd, btnUpdate, btnDel, btnBooking, btnUpdateBooking;
   JRadioButton [] rb = new JRadioButton[3];
   DefaultTableModel model;
   JTable table;
   JScrollPane scrollPane;
   DBConnect db = new DBConnect();

   //생성자
   public Moviemain(String title) {
      super(title);
      
      //위치 너비
      this.setBounds(500, 200, 1000, 600);
      //색상
      cp = this.getContentPane();
      cp.setBackground(Color.WHITE);

      setDegign();
      
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   //디자인
   public void setDegign() {
      this.setLayout(null);
     
      //버튼
      btnAdd = new JButton("차량 등록");
      btnAdd.setBounds(18, 20, 150, 50);
      btnAdd.addActionListener(this);
      this.add(btnAdd);
      btnUpdate = new JButton("차량 수정");
      btnUpdate.setBounds(298, 20, 150, 50);
      btnUpdate.addActionListener(this);
      this.add(btnUpdate);
      btnDel = new JButton("차량 삭제");
      btnDel.setBounds(558, 20, 150, 50);
      btnDel.addActionListener(this);
      this.add(btnDel);
      btnBooking = new JButton("차량 정보 확인");
      btnBooking.setBounds(808, 20, 150, 50);
      btnBooking.addActionListener(this);
      this.add(btnBooking);
      
      //라디오 버튼
      ButtonGroup bg = new ButtonGroup();
      String [] rb_label = {"이름 순","가격 순","연비 순"};
      
      int xpox = 20;
      for(int i =0; i <rb.length; i++) {
    	  //라디오버튼 생성
    	  rb[i] = new JRadioButton(rb_label[i], i==0?true:false);
    	  rb[i].setBounds(xpox, 80, 100, 50);
    	  rb[i].setFont(new Font("",Font.BOLD,15));
    	  //rb[i].setBackground(Color.white);
    	  rb[i].setOpaque(false);
    	  rb[i].addItemListener(this);
    	  bg.add(rb[i]);
    	  this.add(rb[i]);
    	  xpox += 400;
      }
      //테이블
      String[] title = {"차번호", "차이름", "색상", "가격", "연비", "출고일"};
      model = new DefaultTableModel(title, 0);
      table = new JTable(model);
      
      // 테이블에 스크롤 추가
      scrollPane = new JScrollPane(table);
      scrollPane.setBounds(20, 130, 950, 400);
      this.add(scrollPane);
      selectcar();
      
   }
   
   public void selectcar() {
	   model.setRowCount(0);
	   Connection co = db.getConnection();
	   PreparedStatement pst = null;
	   ResultSet re =null;
	   
	   String sql = "select * from car order by num";
	   try {
			pst = co.prepareStatement(sql);
			re = pst.executeQuery();
			
			while (re.next()) {
				Vector<String> data = new Vector<String>();
				data.add(re.getString("num"));
				data.add(re.getString("car_name"));
				data.add(re.getString("car_color"));
				data.add(re.getString("car_pay"));
				data.add(re.getString("car_fuel"));
				data.add(re.getString("car_day"));
				
				model.addRow(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(re, pst, co);
		}	   
	   
   }
   
   public void SelectCar(int select) {
	   String sql="";
	   if(select==1)
		   sql = "String * from car order by car_name";
	   else if(select==2)
		   sql = "String * from car order by car_pay";
	   else if(select==3)
		   sql = "String * from car order by car_fuel";
	   
	   
   }
   //이벤트
   @Override
   public void itemStateChanged(ItemEvent e) {
	   //라디오버튼 제어
	   for(int i =0; i <rb.length; i++) {
		   if(rb[i].isSelected() == true)
			   ;
	   }
   }
   public static void main(String[] args) {
      new Moviemain("");
   
   }

@Override
public void actionPerformed(ActionEvent e) {
}
}
