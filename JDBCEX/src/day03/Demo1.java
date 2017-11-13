package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import day02.Bds;

public class Demo1 {

	public static void main(String[] args) {
		Connection con =null;
		try {
			con = Bds.getConnection();
			con.setAutoCommit(true);
			String sql = "insert into userinfo"
					+ "(id,username,password,email,nickname,account) "
					+ "values "
					+ "(?,?,'123456',?,?,5000)";
			PreparedStatement ps = con.prepareStatement(sql);
			long start = System.currentTimeMillis();
			for(int i=20001;i<=30000;i++){
				ps.setInt(1, i);
				ps.setString(2, "test"+i);
				ps.setString(3, "test"+i+"@qq.com");
				ps.setString(4, "nick"+i);
				ps.executeUpdate();
			}
			long end = System.currentTimeMillis();
			System.out.println("插入成功，耗时："+(end - start)+"ms");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
