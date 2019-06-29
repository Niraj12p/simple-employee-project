package org.niraj.util;
import java.sql.*;
public class DbConnection {

	public static Connection getDbConnection() throws SQLException, ClassNotFoundException{
		String uname="root";
		String pwd="niraj";
		String url="jdbc:mysql://localhost:3306/dbtest";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		try {
		       con = DriverManager.getConnection(url,uname,pwd);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		return con;
	}


}
