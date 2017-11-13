package day02;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class Bds {
	
	private static BasicDataSource bds;
	static{
		Properties prop = new Properties();
		try{
			prop.load(new FileInputStream("src\\day02\\config.properties"));
			bds = new BasicDataSource();
			bds.setDriverClassName(prop.getProperty("drivername"));
			bds.setUrl(prop.getProperty("url"));
			bds.setUsername(prop.getProperty("username"));
			bds.setPassword(prop.getProperty("password"));
			bds.setInitialSize(Integer.parseInt(prop.getProperty("initialsize")));
			bds.setMaxActive(Integer.parseInt(prop.getProperty("maxactive")));
			bds.setMaxIdle(Integer.parseInt(prop.getProperty("maxidle")));
			bds.setMinIdle(Integer.parseInt(prop.getProperty("minidle")));
			bds.setMaxWait(Integer.parseInt(prop.getProperty("maxwait")));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return bds.getConnection();
	}
	
	public void closeConnection(Connection con){
		try {
			if(con != null){
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getMaxActive(){
		return bds.getMaxActive();
	}

}
