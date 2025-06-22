package com.LibTrack.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	static String url="jdbc:mysql://localhost:3306/libtrack";
	static String userName="root";
	static String password="password";
	
	public static Connection getConection(){
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,userName,password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return con;	
	}

}
