package com.db.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnection {
//	throws ClassNotFoundException, SQLException
	public static Connection connectDB() throws SQLException, ClassNotFoundException  {
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		
		String con_string = "jdbc:mysql://127.0.0.1:3306/manageEmployee";
		Connection con = DriverManager.getConnection(con_string,"root", "password");
	
	       return con;
			
	}	
	
    

}
