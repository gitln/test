package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class demo1 {
	
	public static void main(String args[]){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"linan",
					"linan"
					);
			System.out.println("成功连接数据库!");
			Statement state = conn.createStatement();
			String sql = "create table userinfo("
					+ "id number(6),"
					+ "username varchar2(50),"
					+ "password varchar2(50),"
					+ "email varchar2(100),"
					+ "nickname varchar2(50),"
					+ "account number(10,2)"
					+ ")";
			System.out.println(sql);
			state.execute(sql);
			System.out.println("执行成功");
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
