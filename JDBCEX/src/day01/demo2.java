package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class demo2 {
	
	public static void main(String args[]){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"linan",
					"linan");
			System.out.println("已连接数据库！");
			Statement state = conn.createStatement();
			String sql = "create sequence seq_userinfo_id"
					+ " start with 1"
					+ " increment by 1";
			System.out.println(sql);
			state.execute(sql);
			System.out.println("执行成功！");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
