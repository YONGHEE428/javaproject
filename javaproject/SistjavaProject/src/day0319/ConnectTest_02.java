package day0319;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTest_02 {

    static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
            
    public void ex2() {
    	Connection cn = null;
    	Statement st = null;
    	ResultSet re = null;
    	
    	String sql = "select c.idx , s.sangpum, s.color, c.cnt, c.guipday from cart1 c, shop s where c.num = s.num";
    	
    	try {
			cn = DriverManager.getConnection(URL, "dydgml", "a1234");
			st = cn.createStatement();
			re = st.executeQuery(sql);
			
			while(re.next()) {
				int num = re.getInt(1);
				String sangpum = re.getString(2);
				String color = re.getString(3);
				int cnt = re.getInt(4);
				Date day = re.getDate(5);
				
				System.out.println(num + "\t"+sangpum+"\t"+color+"\t"+cnt+"\t"+day);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(re!=null)re.close();
				if(st!=null)st.close();
				if(cn!=null)cn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
    	
    }
    
    
    
    
    
    
    
    
    
    public void conncetfood() {
        Connection cn= null;
        Statement st = null;
        ResultSet re = null;
        
        String sql = "SELECT foodorder.fno 주문번호, " // 열번호로 사용하면 별칭 자유 
                + "foodorder.order_name 주문자이름, "	// 열번호가 아님 이름을 적으면 별칭도 똑같이 해야함
                + "foodmenu.food_name , "			// 아니면 객체 이름이랑 같게 쓰거나
                + "foodmenu.price, "
                + "foodmenu.shop_name, "
                + "foodmenu.loc, "
                + "foodorder.addr "
                + "FROM foodmenu "
                + "INNER JOIN foodorder ON foodmenu.fno = foodorder.fno";
            
        try {
            cn = DriverManager.getConnection(URL, "dydgml","a1234");
            
            st = cn.createStatement();
            re = st.executeQuery(sql);
            
            System.out.println("주문번호\t주문자\t음식명\t\t가격\t상호명\t\t가게위치\t\t주문자주소");
            System.out.println("-".repeat(100));
            while(re.next()) {
                int fno = re.getInt(1);
                String name = re.getString("주문자이름");
                String food_name = re.getString("food_name");
                int price = re.getInt(4);
                String shop_name = re.getString(5);
                String loc = re.getString(6);
                String addr = re.getString(7);
                
               
                System.out.println(fno + "\t" + name + "\t" + food_name + "\t\t" + price + "\t" + shop_name + "    \t" + loc + "\t" + addr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(re != null) re.close();
                if(st != null) st.close();
                if(cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void ex3() {
    	Connection cn = null;
    	Statement st = null;
    	ResultSet re = null;
    	
    	String sql = "select buseo as 부서명, to_char(avg(pay),'l999,999,999')||'원' 평균급여,to_char(max(pay), 'l999,999,999')||'원' 최고급여, to_char(min(pay), 'l999,999,999')||'원' 최저급여 from sawon group by buseo";
    			
    	
    	 try {
			cn = DriverManager.getConnection(URL, "dydgml","a1234");
			st = cn.createStatement();
		    re = st.executeQuery(sql);
		    
		    System.out.println("부서\t평균금액\t\t최고급여\t\t최저급여");
		    System.out.println("-".repeat(100));
		    while(re.next()) {
		    	String buseo = re.getString("부서명");
		    	String avg = re.getString("평균급여");
		    	String max = re.getString("최고급여");
		    	String min = re.getString("최저급여");
		    	
		    	System.out.println(buseo + "\t"+avg+"\t"+max+"\t"+min);

		    	//System.out.println(buseo + "\t" +
                     //   String.format("%,d원", avg) + "\t" +
                     //   String.format("%,d원", max) + "\t" +
                    //    String.format("%,d원", min));
		    }
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            try {
                if(re != null) re.close();
                if(st != null) st.close();
                if(cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         
      
    	
    }
    
    
    
    
    
    public static void main(String[] args) {
        ConnectTest_02 co = new ConnectTest_02();
        //co.conncetfood();
        co.ex3();
    }
}
