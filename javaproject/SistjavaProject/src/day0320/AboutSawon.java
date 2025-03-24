package day0320;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day0319.DBConnect;

public class AboutSawon {
	DBConnect db = new DBConnect();
	Scanner sc = new Scanner(System.in);
	
	//데이타 입력
	public void insertSawon() {
		System.out.println("*** 사원추가하기 ***");
		System.out.print("사원명 : ");
		String name = sc.nextLine();
		System.out.print("성병(남자/여자) : ");
		String gender = sc.nextLine();
		System.out.print("부서 : ");
		String buseo = sc.nextLine();
		System.out.print("월급여 : ");
		int pay = Integer.parseInt(sc.nextLine());
		
		String sql = "insert into sawon values (seq_sawon.nextval, '" + name + "','" + gender + "','" + buseo + "'," + pay+")";
		System.out.println(sql);
		
		Connection cn = db.getConnection();
		Statement st = null;
		
		try {
			st = cn.createStatement();
			st.execute(sql);
			
			System.out.println("***DB에 사원이 추가!!!***");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(st, cn);
		}	
	}
	
	// 데이터  출력
	public void selectSawon() {
		Connection cn =db.getConnection();
		Statement st = null;
		ResultSet re = null;
		
		
		System.out.println("번호\t이름\t성별\t부서\t월급");
		String sql = "select * from sawon";
		
		try {
			st = cn.createStatement();
			re = st.executeQuery(sql);
		
			while (re.next()) {
				int num = re.getInt(1);
				String name = re.getString(2);
				String gender = re.getString(3);
				String buseo = re.getString(4);
				int pay = re.getInt(5);
				
				System.out.println(num+"\t"+name+"\t"+gender+"\t"+buseo+"\t"+pay+"원");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(re, st, cn);
		}
	}
	
	//수정..시퀀스입력후 이름,부서,급여
	public void updateSawon() {
		Connection cn = db.getConnection();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수정할 사원의 번호를 입력해주세요(취소:0): ");
		int num = Integer.parseInt(sc.nextLine());
		if(num==0) {
			System.out.println("***데이타 수정을 취소합니다.***");
			return;
		}
		else if(this.datacheck(num) == false) {
			System.out.println("***해당 번호의 사원이 없습니다.***");
			updateSawon();
			return;
		}
		System.out.print("수정할 사원명 :  ");
		String name = sc.nextLine();
		System.out.print("수정할 부서명 : ");
		String buseo = sc.nextLine();
		System.out.print("수정할 급여 : ");
		int pay = Integer.parseInt(sc.nextLine());
		
		String sql = "update sawon set name = '"+name+"', buseo = '"+buseo+"', pay = " + pay +"where num = " +num;
		
		Statement st = null;
		
		try {
			st =cn.createStatement();
			int a = st.executeUpdate(sql);
			if(a == 1) {
				System.out.println("***해당 사원의 데이타를 수정하였습니다.***");
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(st, cn);
		}
	}
	//데이타존재여부 체크하는 메소드
	public boolean datacheck(int num) {
		boolean flag = false;
		
		String sql = "select * from sawon where num =" + num ;
		
		Connection cn = db.getConnection();
		Statement st = null;
		ResultSet re = null;
		
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
	// 데이타 삭제 
	public void deleteSawon() {
		Connection cn = db.getConnection();
		Statement st = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 시퀀스 번호를 입력해주세요(취소:0) : ");
		int n = Integer.parseInt(sc.nextLine());
		if(n==0) {
			System.out.println("***데이타 삭제를 취소합니다.***");
			return;
		}
		String sql = "delete from sawon where num = " + n;
			
		try {
			st = cn.createStatement();
			int a = st.executeUpdate(sql);
			if(a == 1)
				System.out.println("***삭제가 완료되었습니다.***");
			else if(a==0) {
				System.out.println("***해당 시퀀스 번호가 존재하지 않습니다.***");
				deleteSawon();
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(st, cn);
		}
	}
	//데이타가 있는지 조회
	public boolean datacheck2(String sung) {
		boolean flag = false;
		
		String sql = "select * from sawon where name like '" + sung +"%'";
		
		Connection cn = db.getConnection();
		Statement st = null;
		ResultSet re = null;
		
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
	
	//데이타 검색
	public void searchsawon() {
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 사원의 성을 입력하세요 : ");
		String sung = sc.nextLine();
		if(datacheck2(sung)== false) {
			System.out.println("해당 성을 가진 사원이 없습니다.");
			searchsawon();
			return;
		}
		
		System.out.println("번호\t이름\t성별\t부서\t월급");
		String sql = "select * from sawon where name like '" + sung + "%'";
		
		Connection cn = db.getConnection();
		Statement st = null;
		ResultSet re = null;
		
		try {
			st=cn.createStatement();
			re = st.executeQuery(sql);
			
			while(re.next()) {
			/*	int num = re.getInt(1);
				String name = re.getString(2);
				String gender = re.getString(3);
				String buseo = re.getString(4);
				int pay = re.getInt(5);*/
				
				System.out.println(re.getInt(1) + "\t" + re.getString(2) + "\t" + re.getString(3) + "\t" + re.getString(4) +"\t"+ re.getInt(5)+"원");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(re, st, cn);
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		AboutSawon ab = new AboutSawon();
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("\t\t    ***** Oracle Sawon 연습 *****");
		while (true) {
			System.out.println("-".repeat(72));
			System.out.print("1번.데이타 입력  2.데이타 출력  3.데이타 수정  4.데이타 삭제  5.데이타 검색  9.종료    ");
			n = Integer.parseInt(sc.nextLine());
			System.out.println("-".repeat(72));
			if(n ==1 )
				ab.insertSawon();
			else if (n==2)
				ab.selectSawon();
			else if(n==3)
				ab.updateSawon();
			else if(n==4)
				ab.deleteSawon();
			else if(n==5)
				ab.searchsawon();
			else if(n == 9) {
				System.out.println("***시스템을 종료합니다.***");
				break;
				
			}
		}
	}
}
