package day0321;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import day0319.DBConnect;

public class StuInfo {

	DBConnect db = new DBConnect();
	Scanner sc = new Scanner(System.in);
	
	public void Insert() {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생의 이름은? :");
		String name = sc.nextLine();
		System.out.print("학생의 주소는? : ");
		String addr = sc.nextLine();
		System.out.print("학생의 혈액형은? : ");
		String blood = sc.nextLine();
		System.out.print("학생의 전화번호는? : ");
		String hp = sc.nextLine();
		System.out.print("학생의 학년은? : ");
		int grade = Integer.parseInt(sc.nextLine());
		System.out.print("학생의 나이는? : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("학생의 생일은? : ");
		String birth = sc.nextLine();
		
		String sql = "insert into stuinfo values(seq_club.nextval, ? , ? , ? , ? , ? , ? , ? , sysdate)";
		
		Connection cn = db.getConnection();
		PreparedStatement pst = null;
		
		try {
			pst = cn.prepareStatement(sql);
			
			pst.setString(1, name);
			pst.setString(2, addr);
			pst.setString(3, blood);
			pst.setString(4, hp);
			pst.setInt(5, grade);
			pst.setInt(6, age);
			pst.setString(7, birth);
			
			int n = pst.executeUpdate();
			
			if (n==1)
				System.out.println("***Insert 성공!!***");
			else
				System.err.println("***Insert 실패!!***");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(pst, cn);
		}
	}
////////////////////////////////////////////////////////////////////////////
	public void Select() {
		Connection cn = db.getConnection();
		Statement st = null;
		ResultSet re = null;
		
		String sql = "select * from stuinfo";
		System.out.println("번호\t이름\t주소\t\t혈액형\t전화번호\t\t학년\t나이\t생일\t등록날짜");
		try {
			st = cn.createStatement();
			re = st.executeQuery(sql);
			
			while(re.next()) {
				System.out.println(re.getInt(1) + "\t" + re.getString(2) + "\t" + re.getString(3) + "\t" + re.getString(4)
				 + "\t" + re.getString(5) + "\t" + re.getInt(6) + "학년\t" + re.getInt(7) + "세\t" + re.getString(8) + "\t" + re.getDate(9));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(re, st, cn);
		}
	}
////////////////////////////////////////////////////////////////////////////	
	public void Delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 학생의 번호를 입력해주세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		if(DeleteCheck(num)==false) {
			System.err.println("***해당 번호의 학생이 존재하지 않습니다.***");
			return;
		}
		String sql = "delete stuinfo where stu_no = " + num;
		
		Connection cn = db.getConnection();
		Statement st = null;
		
		try {
			st = cn.createStatement();
			int n = st.executeUpdate(sql);
			
			if(n==1)
				System.out.println("***Delete 성공!!***");
			else
				System.err.println("***Delete 실패!!***");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(st, cn);
		}
		
		
	}
////////////////////////////////////////////////////////////////////////////
	public boolean DeleteCheck(int num) {
		boolean flag = false;
		Connection cn = db.getConnection();
		Statement st = null;
		ResultSet re = null;
		
		String sql = "select * from stuinfo where stu_no = " + num;
		
		try {
			st = cn.createStatement();
			re = st.executeQuery(sql);
			
			if(re.next())
				flag = true;
			else
				flag = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(re, st, cn);
		}
		return flag;
	}
////////////////////////////////////////////////////////////////////////////
	public void Update() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 학생의 번호를 입력해 주세요: ");
		int num = Integer.parseInt(sc.nextLine());
		if(UpdateCheck(num)==false) {
			System.err.println("***해당 학생은 존재하지 않습니다.***");
			return;}
		System.out.print("학생의 이름은? :");
		String name = sc.nextLine();
		System.out.print("학생의 주소는? : ");
		String addr = sc.nextLine();
		System.out.print("학생의 혈액형은? : ");
		String blood = sc.nextLine();
		System.out.print("학생의 전화번호는? : ");
		String hp = sc.nextLine();
		System.out.print("학생의 학년은? : ");
		int grade = Integer.parseInt(sc.nextLine());
		System.out.print("학생의 나이는? : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("학생의 생일은? : ");
		String birth = sc.nextLine();
		
		String sql = "update stuinfo set stu_name = ? , stu_addr = ? , stu_blood = ? ,"
				+ "stu_hp = ? , stu_grade = ? , stu_age = ? , birth = ? where stu_no = " + num;
		
		Connection cn = db.getConnection();
		PreparedStatement pst = null;
		
		try {
			pst = cn.prepareStatement(sql);
			
			pst.setString(1, name);
			pst.setString(2, addr);
			pst.setString(3, blood);
			pst.setString(4, hp);
			pst.setInt(5, grade);
			pst.setInt(6, age);
			pst.setString(7, birth);
			
			int n = pst.executeUpdate();
			
			if (n==1)
				System.out.println("***Insert 성공!!***");
			else
				System.err.println("***Insert 실패!!***");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(pst, cn);
		}
		
	}
	public boolean UpdateCheck(int num) {
		boolean flag = false;
		Connection cn = db.getConnection();
		Statement st = null;
		ResultSet re = null;
		
		String sql = "select * from stuinfo where stu_no = " + num;
		
		try {
			st = cn.createStatement();
			re = st.executeQuery(sql);
			
			if(re.next())
				flag = true;
			else
				flag = false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(re, st, cn);
		}
		return flag;
	}
////////////////////////////////////////////////////////////////////////////	
	public void Search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 학생의 성을 입력해주세요: ");
		String sung = sc.nextLine();
		
		String sql = "select * from stuinfo where stu_name like ?";
		
		Connection cn = db.getConnection();
		PreparedStatement pst = null;
		ResultSet re = null;
		
		try {
			pst = cn.prepareStatement(sql);
			
			pst.setString(1, sung + "%");
			
			re = pst.executeQuery();
			
			if(re.next()) {
				System.out.println("***검색 성공!!***");
				do {
					System.out.println(re.getInt(1) + "\t" + re.getString(2) + "\t" + re.getString(3)
					 + "\t" + re.getString(4) + "\t" + re.getString(5) + "\t" + re.getInt(6) + "학년\t"
							+ re.getInt(7) + "세\t" + re.getString(8) + "\t" + re.getDate(9));
				}while (re.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(re, pst, cn);
		}
	}
	
////////////////////////////////////////////////////////////////////////////	
	public static void main(String[] args) {
		StuInfo st = new StuInfo();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\t\t\t***학생정보 시스템***");
		
		while (true) {
			System.out.println("-".repeat(80));
			System.out.print("1.학생정보 입력  2.학생정보 출력  3.학생정보 삭제  4.학생정보 수정  5.학생검색(성)  9.종료    ");
			int n = Integer.parseInt(sc.nextLine());
			
			if(n==1)
				st.Insert();
			if(n==2)
				st.Select();
			if(n==3)
				st.Delete();
			if(n==4)
				st.Update();
			if(n==5)
				st.Search();
			if(n==9) {
				System.out.println("***시스템 종료***");
				return;}
		}	
	}
}
