package day0321;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import day0319.DBConnect;

public class ShopTest {

	DBConnect db = new DBConnect();
	Scanner sc = new Scanner(System.in);
	
	public void insertSangPum() {
		
		Connection cn = db.getConnection();
		PreparedStatement pst = null;
		
		System.out.print("상품 타입은?(음료 or 과자) : ");
		String type = sc.nextLine();
		System.out.print("상품명은? : ");
		String name = sc.nextLine();
		System.out.print("수량은? : ");
		int su = Integer.parseInt(sc.nextLine());
		System.out.print("단가는? : ");
		int dan = Integer.parseInt(sc.nextLine());
		
		//pareparedStatement 객체는 미완의 sql문을 작성할 수 있다
		//변수를 ?로 표시후 나중에 바인딩시켜준다
		String sql = "insert into sales values(seq_club.nextval , ? , ? , ? , ? , sysdate)";
		
		try {
			pst = cn.prepareStatement(sql);
			
			pst.setString(1, type);
			pst.setString(2, name);
			pst.setInt(3, su);
			pst.setInt(4, dan);
			
			int n = pst.executeUpdate();
			
			if(n==1)
				System.out.println("Insert 성공");
			else
				System.err.println("Insert 실패");
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			db.dbClose(pst, cn);
		}
	}
	
	public void selectSangpum() {
		Connection cn = db.getConnection();
		Statement st = null;
		ResultSet re = null;
		
		String sql = "select * from sales";
		System.out.println("번호\t타입\t이름\t수\t단가\t입고날짜");
		try {
			st = cn.createStatement();
			re = st.executeQuery(sql);
			
			while(re.next()) {
				int num = re.getInt(1);
				String type = re.getString(2);
				String name = re.getString(3);
				int su = re.getInt(4);
				int dan = re.getInt(5);
				Date date = re.getDate(6);
				
				System.out.println(num + "\t" + type + "\t" + name + "\t" + su + "\t" + dan + "\t" + date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(re, st, cn);
			
		}
		
	}
	
	public void updateSangpum() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수정할 상품 번호를 입력하여 주세요 : ");
		int n = Integer.parseInt(sc.nextLine());
		if(check(n)==false) {
			System.out.println("상품 번호가 없습니다.");
			return;
		}
		System.out.print("상품 타입은?(음료 or 과자) : ");
		String type = sc.nextLine();
		System.out.print("상품명은? : ");
		String name = sc.nextLine();
		System.out.print("수량은? : ");
		int su = Integer.parseInt(sc.nextLine());
		System.out.print("단가는? : ");
		int dan = Integer.parseInt(sc.nextLine());
		
		String sql = "update sales set type = ? , sangpum = ? , su = ? , dan = ? where num = "+n;
		
		Connection cn = db.getConnection();
		PreparedStatement pst = null;
		
		try {
			pst=cn.prepareStatement(sql);
			
			pst.setString(1, type);
			pst.setString(2, name);
			pst.setInt(3, su);
			pst.setInt(4, dan);
			
			int a= pst.executeUpdate();
			if(a==1)
				System.out.println("Update 성공");
			else
				System.out.println("Update 실패");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(pst, cn);
			
		}
		
	}
	public boolean check(int num) {
		boolean flag = false;
		Connection cn = db.getConnection();
		Statement st = null;
		ResultSet re = null;
		
		String sql = "select * from sales where num = "+num;
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
	
	public void SearchSangpum() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("찾으실 상품의 상품명을 입력하여 주세요 : ");
		String sangpumname = sc.nextLine();
		if(check2(sangpumname)==false){
			System.out.println("해당 이름의 상품이 존재 하지 않습니다.");
			return;
		}
		String sql = "select * from sales where sangpum like '%"+ sangpumname +"%'";
		
		Connection cn = db.getConnection();
		Statement st = null;
		ResultSet re = null;
		
		try {
			st = cn.createStatement();
			re = st.executeQuery(sql);
			
			while(re.next()) {
			System.out.println(re.getInt(1) + "\t" + re.getString(2) + "\t" + re.getString(3) + "\t" + re.getInt(4) + "\t" + re.getInt(5) + "\t" + re.getDate(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(re, st, cn);
		}
	}
	public boolean check2(String name) {
		boolean flag = false;
		Connection cn = db.getConnection();
		Statement st = null;
		ResultSet re = null;
		
		String sql = "select * from sales where sangpum like '%" + name + "%'";
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
	
	public void Deletesangpum() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 상품의 번호를 입력해주세요: ");
		int num = Integer.parseInt(sc.nextLine());
		
		String sql = "delete sales where num = "+num;
		
		Connection cn = db.getConnection();
		Statement st = null;
		
		try {
			st = cn.createStatement();
			int a = st.executeUpdate(sql);
			
			if(a==1)
				System.out.println("해당 상품이 삭제되었습니다.");
			else
				System.out.println("해당 상품은 존재하지 않습니다.");
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			db.dbClose(st, cn);
		}
		
	}
	
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public static void main(String[] args) {
		ShopTest sh = new ShopTest();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("**상품 입고**");
		
		while( true) {

			System.out.println("1. 상풉 입고  2. 상품 확인  3. 상품 수정  4. 상품 검색  5. 상품 삭제  9. 취소");
			System.out.println("-".repeat(70));
			int n = Integer.parseInt(sc.nextLine());
			if(n==1)
				sh.insertSangPum();
			else if(n==2)
				sh.selectSangpum();
			else if(n==3)
				sh.updateSangpum();
			else if(n==4)
				sh.SearchSangpum();
			else if(n==5)
				sh.Deletesangpum();
			else if(n==9) {
				System.out.println("프로그램 종료");
				break;}
		}
	}
}
