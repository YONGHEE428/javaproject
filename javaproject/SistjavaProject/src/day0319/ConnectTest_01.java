package day0319;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTest_01 {

	static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	public void connectSawon() {
		
		Connection conn = null; //1번 연결
		Statement stmt = null; //2번 연결한 오라클에서 sql 호출
		ResultSet rs = null;	 //3번 출력
		
		String sql = "select * from sawon order by num"; //사원테이블을 num의 오름차순정렬하여 조회
		try {
			conn = DriverManager.getConnection(URL, "dydgml", "a1234");
	
			System.out.println("오라클서버에 접속 성공");
			
			stmt=conn.createStatement(); // sql요청
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				// db로부터 데이타 가져오기
				int num = rs.getInt("num"); //1열
				String name = rs.getString("name"); //2열 = name
				String gender = rs.getString(3);
				String buseo = rs.getString("buseo");
				int pay = rs.getInt(5);
				
				System.out.println(num + "\t" + name + "\t" + gender + "\t" + buseo + "\t" + pay);
			}
		
		} catch (SQLException e) {
			System.out.println("오라클서버에 접속 실패");

		}finally {
				try {
					if(rs != null) rs.close();
					if(stmt != null)stmt.close();
					if(conn!= null)conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
		}
	}
	public static void main(String[] args) {
		ConnectTest_01 ct = new ConnectTest_01();
		ct.connectSawon();
		
	}
}
