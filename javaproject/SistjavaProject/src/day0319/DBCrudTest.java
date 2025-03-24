package day0319;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBCrudTest {

	DBConnect db = new DBConnect();
	
	public void insert() {
		
		Scanner sc = new Scanner(System.in);
		
		String name, addr;
		String sql="";
		
		System.out.print("이름을 입력하시오 : ");
		name = sc.nextLine();
		System.out.print("주소를 입력하시오 : ");
		addr = sc.nextLine();
		
		sql = "insert into hello values (seq_test.nextval , '" + name + "','" + addr + "', sysdate)";
		System.out.println(sql);
			
		Connection cn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet re = null;
		
		cn = db.getConnection();
		try {
			st = cn.createStatement();
			st.execute(sql); //boolean or int 저장할지....
			
			System.out.println("**추가됨**");
		} catch (SQLException e) {
		}finally {
			db.dbClose(st, cn);;
		}
		
	}
	
	public void select() {
		Statement st = null;
		ResultSet re = null;
		
		String sql = "select * from hello";
		System.out.println("번호\t이름\t주소\t\t날짜");
		
		Connection cn = db.getConnection();
		try {
			st = cn.createStatement();
			re = st.executeQuery(sql);
			
			while(re.next()) {
				int num = re.getInt(1);
				String name = re.getString(2);
				String addr = re.getString(3);
				Date date = re.getDate(4);
				
				System.out.println(num + "\t" + name + "\t" + addr + "\t" + date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(re, st, cn);
		}
		
	}
	
	public void update() {
		Scanner sc = new Scanner(System.in);
		int num;
		String name, addr;
		System.out.print("수정할 행의 번호를 입력해 주세요 : ");
		num = Integer.parseInt(sc.nextLine());
		if (this.isData(num) == false) { 
			System.out.println("해당번호는 존재하지 않습니다.");
			update();
			return ;
		}
		System.out.print("수정할 이름을 입력해주세요 : ");
		name = sc.nextLine();
		System.out.print("수정할 주소를 입력해주세요 : ");
		addr = sc.nextLine();
		
		String sql = "update hello set name = '" + name + "', addr = '" + addr + "' where num = " + num;
		
		Statement st = null;
		Connection cn = db.getConnection();
		try {
			st = cn.createStatement();
			int a = st.executeUpdate(sql);
			//없는 번호 입력시 실제 삭제가 안되므로 0
			if(a==0)
				System.out.println("해당 번호의 행이 존재 하지 않습니다.");
			else if(a==1)
				System.out.println("해당 행의 데이터를 수정하였습니다.");
		} catch (SQLException e) {
		}finally {
			db.dbClose(st, cn);
		}
	}
	//수정할 하나의 데이터 조회
	public boolean isData(int num) {
		//num에 해당하는 데이타가 있으면 true, 없으면 false반환
		boolean flag = false;
		
		String sql ="select * from hello where num = "+num;
		
		Connection cn = db.getConnection();
		Statement st = null;
		ResultSet re = null;
		try {
			st = cn.createStatement();
			re = st.executeQuery(sql);
			
			//1개일 경우 if
			if(re.next())
				flag = true; //데이타가 있는경우
			else
				flag = false; // 데이타가 없는경우
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(re, st, cn);
		}
		
		
		
		return flag;
	}
	
	public void delete() {
		
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("삭제할 번호을 선택하여 주세요 : ");
		num = Integer.parseInt(sc.nextLine());
		
		String sql = "delete from hello where num = " + num;
	
		Statement st = null;
		Connection cn = db.getConnection();
		try {
			st = cn.createStatement();
			int a = st.executeUpdate(sql);
			//없는 번호 입력시 실제 삭제가 안되므로 0
			if(a==0)
				System.out.println("해당 번호의 행이 존재 하지 않습니다.");
			else if(a==1)
				System.out.println("해당 번호의 행을 삭제하였습니다.");
		} catch (SQLException e) {

		} finally {
			db.dbClose(st, cn);
		}
		
	}
	
	
	public static void main(String[] args) {
		DBCrudTest db = new DBCrudTest();
		
		Scanner sc = new Scanner(System.in);
		int n;
		
		while(true) {
			System.out.println("-".repeat(50));
			System.out.print("1.insert 2.select 3.update 4.delete 9.exit      ");
			n = Integer.parseInt(sc.nextLine());
			System.out.println("-".repeat(50));
			
			
			if(n==1)
				db.insert();
			else if(n==2)
				db.select();
			else if(n==3)
				db.update();
			else if(n==4)
				db.delete();
			else if(n==9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
				
		}
		
	}
}
