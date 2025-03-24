package day0324;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import day0319.DBConnect;

public class InsertScore  extends JFrame implements ActionListener{

   Container cp;
   JTextField TfName,TfJave,TfJsp,TfSpring;
   JComboBox<String> CbBan;
   JButton btnAdd;
   DBConnect db = new DBConnect();
   //생성자
   public InsertScore(String title) {
      super(title);
      
      //위치 너비
      this.setBounds(1100, 250, 300, 400);
      //색상
      cp = this.getContentPane();
      cp.setBackground(new Color(220,220,220));

      setDegign();
      
     //this.setVisible(true);
    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   //디자인
   public void setDegign() {
      this.setLayout(null);
      
      JLabel title1 = new JLabel("학생명");
      JLabel title2 = new JLabel("반");
      JLabel title3 = new JLabel("Java");
      JLabel title4 = new JLabel("Jsp");
      JLabel title5 = new JLabel("spirng");
      
      title1.setBounds(5, 10, 60, 30);
      this.add(title1);
      title2.setBounds(5, 60, 60, 30);
      this.add(title2);
      title3.setBounds(5, 110, 60, 30);
      this.add(title3);
      title4.setBounds(5, 160, 60, 30);
      this.add(title4);
      title5.setBounds(5, 210, 60, 30);
      this.add(title5);
      
      TfName = new JTextField(4);
      TfName.setBounds(80, 10, 150, 30);
      this.add(TfName);
      
      String [] ban = {"1강의장","2강의장","3강의장","4강의장"};
      CbBan = new JComboBox<String>(ban);
      CbBan.setBounds(80, 62, 100, 30);
      this.add(CbBan);
      
      TfJave = new JTextField(4);
      TfJave.setBounds(80, 110, 150, 30);
      this.add(TfJave);
      
      TfJsp = new JTextField(4);
      TfJsp.setBounds(80, 160, 150, 30);
      this.add(TfJsp);
      
      TfSpring = new JTextField(4);
      TfSpring.setBounds(80, 210, 150, 30);
      this.add(TfSpring);
      
      //브턴
      btnAdd = new JButton("점수추가");
      btnAdd.setBounds(90,280,100,50);
      btnAdd.addActionListener(this);
      this.add(btnAdd);
      
      
      
   }
   //이벤트
   @Override
   public void actionPerformed(ActionEvent e) {

   }
   
   //public static void main(String[] args) {
    // new InsertScore("상점 추가폼");
   
  // }


}
