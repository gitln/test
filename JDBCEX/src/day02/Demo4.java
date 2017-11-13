package day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Demo4 { 
	static String driver;
	static String url;
	static String username;
	static String password;
	static Connection con = null;
	static{
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src\\day02\\config.properties"));
			driver = prop.getProperty("drivername");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		return con;
	}

}
