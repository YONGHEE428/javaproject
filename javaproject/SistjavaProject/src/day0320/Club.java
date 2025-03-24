package day0320;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import day0319.DBConnect;

public class Club {

	DBConnect db = new DBConnect();
	
	///회원가입
	public void insertClub() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력해주세요(취소:0) : ");
		String name = sc.nextLine();
		if(name.equals("0")) {
			System.err.println("***회원가입을 취소합니다.***");
			return;}
		System.out.print("주소를 입력해주세요 : ");
		String addr = sc.nextLine();
		System.out.print("직급을 입력해주세요 : ");
		String position = sc.nextLine();
		System.out.print("전화번호를 입력해주세요 : ");
		String hp = sc.nextLine();

		
		String sql = "insert into myclub (cno,cname,caddress,cposition,chp,gaipday) values(seq_club.nextval,'"+name+"','"+addr+"','"+position+"','"+hp+"',sysdate)";
			
		Connection cn = db.getConnection();
		Statement st = null;
		
		try {
			st = cn.createStatement();
			st.execute(sql);
			System.err.println("****회원가입 성공****");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(st, cn);
		}
	}
	
	////전체회원 출력
	public void selectClub() {
		Connection cn = db.getConnection();
		Statement st = null;
		ResultSet re = null;
		
		 String sql = "select * from myclub order by case cposition when '회장' then 1 when '부장' then 2 when '총무'"
		 		+ " then 3 when '회원' then 4 else 5 end";
		System.out.println("번호\t회원명\t주소\t\t직급\t전화번호\t\t회비\t가입일");
		
		try {
			st = cn.createStatement();
			re = st.executeQuery(sql);
			
			while (re.next()) {
				System.out.println(re.getInt(1)+"번\t"+re.getString(2)+"\t"+re.getString(3)+"\t"+re.getString(4)+
						"\t"+re.getString(5)+"\t"+re.getInt(6)+"원\t"+re.getDate(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(re, st, cn);
		}
	}
	
	////회원정보 수정
	public void updateClub() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 회원의 번호를 입력하시오(취소:0) : ");
		int num = Integer.parseInt(sc.nextLine());
		if(num == 0) {
			System.err.println("***회원정보수정을 취소합니다.***");
			return;}
		else if(CnoCheck(num)==false) {
			System.err.println("***해당번호의 회원이 존재하지 않습니다.***");
			updateClub();
			return;}
		System.out.print("수정할 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		System.out.print("수정할 주소를 입력해주세요 : ");
		String addr = sc.nextLine();
		System.out.print("수정할 직급 입력해주세요 : ");
		String position = sc.nextLine();
		System.out.print("수정할 전화번호를 입력해주세요");
		String hp = sc.nextLine();
		System.out.print("수정할 회비를 입력해주세요 : ");
		int fee = Integer.parseInt(sc.nextLine());
		
		String sql = "update myclub set cname = '" + name + "', caddress = '" + addr + "', "
				+ "cposition = '" + position + "', chp = '" + hp + "', cfee = " + fee +"where cno = " + num; 
		
		Connection cn = db.getConnection();
		Statement st = null;
		
		try {
			st = cn.createStatement();
			int a = st.executeUpdate(sql);
			
			if(a==1)
				System.err.println("***회원정보수정이 완료되었습니다.***");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(st, cn);	
		}
	}
	///데이터 체크 메서드
	public boolean CnoCheck(int num) {
		boolean flag = false;
		
		Connection cn = db.getConnection();
		Statement st = null;
		ResultSet re = null;
		
		String sql = "select * from myclub where cno = "+num;
		
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
	
	///회원삭제
	public void deleteClub() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 회원의 번호를 입력해주세요(취소:0) : ");
		int num = Integer.parseInt(sc.nextLine());
		if(num == 0) {
			System.err.println("***회원삭제를 취소합니다.***");
			return;}
		
		String sql = "delete myclub where cno = "+num;
		
		Connection co = db.getConnection();
		Statement st = null;
		
		try {
			st = co.createStatement();
			int a = st.executeUpdate(sql);
			
			if(a == 1)
				System.err.println("회원을 삭제 하였습니다.");
			else if (a == 0) {
				System.err.println("해당 회원이 존재하지 않습니다.");
				deleteClub();
				return;}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.dbClose(st, co);
		}
	}
	//메인 함수
	public static void main(String[] args) {
		Club cl = new Club();
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("\t\t    ***** 쌍용아카데미 회원 *****");
		while (true) {
			System.out.println("-".repeat(72));
			System.out.print("1번.회원가입  2.전체회원출력  3.회원정보수정  4.회원삭제  9.종료    ");
			n = Integer.parseInt(sc.nextLine());
			System.out.println("-".repeat(72));
			if(n ==1 )
				cl.insertClub();
			else if (n==2)
				cl.selectClub();
			else if(n==3)
				cl.updateClub();
			else if(n==4)
				cl.deleteClub();
			else if(n == 9) {
				System.err.println("***시스템을 종료합니다.***");
				break;}
			}
	}
}
