package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Demo8 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Bds bds = new Bds();
			con = bds.getConnection();
			String sql = "select * from userinfo";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(
					rsmd.getColumnCount()
					);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
