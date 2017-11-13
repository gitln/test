package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo6 {

	public static void main(String[] args) {
		Connection con = null;
		Bds bds = new Bds();
		try {
			con = bds.getConnection();
			String sql = "select * from userinfo";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(2));
			}
			con.close();
			System.out.println(bds.getMaxActive());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
