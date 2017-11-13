package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.println("欢迎注册！");
			System.out.println("请输入用户名：");
			String username = scanner.nextLine();
			System.out.println("输入密码：");
			String password = scanner.nextLine();
			System.out.println("请输入邮箱地址：");
			String email = scanner.nextLine();
			System.out.println("请输入昵称：");
			String nickname = scanner.nextLine();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE",
					"linan",
					"linan");
			String sql = "insert into userinfo"
					+ "(username,password,email,nickname,account) "
					+ "values "
					+ "('" + username + "','" + password + "','" + email + "','" + nickname + "',5000)";
			System.out.println(sql);
			Statement state = conn.createStatement();
			for(int m = 0;m<6;m++){
				int i = state.executeUpdate(sql);
				if(i>0){
					System.out.println("执行成功！");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
