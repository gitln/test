package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
		Connection conn = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"linan",
					"linan");
			String sql = "insert into userinfo "
					+ "(id,username,password,email,nickname,account) "
					+ "values "
					+ "(seq_userinfo_id.nextval,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "xiaotian");
			ps.setString(2, "55482");
			ps.setString(3, "1050715006@qq.com");
			ps.setString(4, "tiantian");
			ps.setDouble(5, 5000.00);
			int a = ps.executeUpdate();
			if(a>0){
				System.out.println("注册成功");
			}else{
				System.out.println("注册失败");
			}
		}catch(Exception e) {
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
