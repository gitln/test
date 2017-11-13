package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"linan",
					"linan");
			String sql = "select * from userinfo "
					+ "where username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			String username = sc.nextLine();
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				System.out.println("用户名已存在");
			}else{
				System.out.println("用户名可以使用");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
