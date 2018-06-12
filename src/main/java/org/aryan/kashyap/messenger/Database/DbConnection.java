package org.aryan.kashyap.messenger.Database;

import java.sql.*;

public class DbConnection {
	
	public static Connection myConn;
	public static Statement myStmt;
	public static ResultSet myRs;
	
	public static Connection setDbConnection() throws SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			myConn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Chat","root","aryan");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		 return myConn;
	}
	
	public ResultSet getResultSet(String sql,Connection conn) throws SQLException
	{
		myConn=conn;
		try
		{
			myStmt=myConn.createStatement();
			myRs=myStmt.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return myRs;
	}

}
