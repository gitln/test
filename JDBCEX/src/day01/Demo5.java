package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo5 {

	public static void main(String[] args) {
		try {
		Scanner scanner = new  Scanner(System.in);
		System.out.println("请输入每页显示条数：");
		int pagesize = scanner.nextInt();
		System.out.println("请输入显示页数：");
		int page = scanner.nextInt();
		int start = (page - 1) * pagesize + 1;
		int end = pagesize * page;
		int n = 0;
		
		
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"linan",
					"linan");
			Statement state = conn.createStatement();
			String sql = "select * from ("
					+ "select rownum rn,t.* from( "
					+ "	select * from userinfo) t "
					+ "where rownum<=" + end
					+ ") "
					+ "where rn between " + start
					+ " and " + end;
			ResultSet rs = state.executeQuery(sql);
			while(rs.next()){
				n += 1;
			}
			System.out.println(n);
			conn.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}

}
