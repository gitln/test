package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo4 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
					"linan",
					"linan");
			Statement state = conn.createStatement();
			String sql = "select id,username,password,email,nickname,account "
					+ "from userinfo";
			ResultSet rs = state.executeQuery(sql);
			if(rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String nickname = rs.getString("nickname");
				double account = rs.getDouble("account");
				System.out.println(id + "," + username + "," + password + "," + email + "," + nickname + "," + account);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
