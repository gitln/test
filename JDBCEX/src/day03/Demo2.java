package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import day02.Bds;

public class Demo2 {

	public static void main(String[] args) {
		Connection con = null;
		try{
			con = Bds.getConnection();
			String sql = "insert into userinfo(id,username) "
					+ "values "
					+ "(seq_userinfo_id.nextval,?)";
			PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
			ps.setString(1, "nickber");
			int i = ps.executeUpdate();
			if(i>0){
				System.out.println("添加成功！");
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()){
					int id = rs.getInt(1);
					System.out.println("id:" + id);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{			
			try {
				if(con != null){
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}