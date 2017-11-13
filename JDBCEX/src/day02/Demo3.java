package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"linan",
					"linan");
			String sql = "delete from userinfo "
					+ "where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			ps.setInt(1, sc.nextInt());
			int a = ps.executeUpdate();
			if(a>0){
				System.out.println("删除成功");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
