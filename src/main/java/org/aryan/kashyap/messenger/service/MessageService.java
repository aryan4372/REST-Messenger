package org.aryan.kashyap.messenger.service;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import java.util.Date;

import org.aryan.kashyap.messenger.Database.DbConnection;
import org.aryan.kashyap.messenger.model.Likes;
import org.aryan.kashyap.messenger.model.Message;

public class MessageService {

	public DbConnection db;
	
	public  List<Message> getAllMessages() throws SQLException
	{
		
		List<Message> list=new ArrayList<>();
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
		String sql="select * from message";
		ResultSet myRs=db.getResultSet(sql, myConn);
		
		while(myRs.next())
		{
			String id1=myRs.getString("Message_id");
			String message=myRs.getString("message");
			String id2=myRs.getString("Profile_id");
			long id3=Long.parseLong(id2);
			long id=Long.parseLong(id1);
			Message m=new Message(id,message,id3);
			list.add(m);
		}
		return list;
	}
	
	public Message getMessage(long id) throws SQLException
	{
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
		String sql="select * from message where Message_id='"+id+"'";
		ResultSet myRs=db.getResultSet(sql, myConn);
		while(myRs.next())
		{
			String message=myRs.getString("Message");
			String author=myRs.getString("Author");
			String date=myRs.getString("Created");
			String id1=myRs.getString("Profile_id");
			long id2=Long.parseLong(id1);
			Message m=new Message(id,message,date,author,id2);
			return m;
		}
		
		return new Message(0,"error","error","error");
	}
	
	public Likes getLikes(long id) throws SQLException
	{
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
		String sql="select * from likes where Message_id='"+id+"'";
		ResultSet myRs=db.getResultSet(sql, myConn);
		while(myRs.next())
		{
			String profile_id=myRs.getString("Profile_id");
			String author=myRs.getString("UserName");
			long id1=Long.parseLong(profile_id);
			Likes l=new Likes(id1,id,author);
			return l;
		}
		return null;
	}
	
	public Message addMessage(Message message) throws SQLException
	{
		String msg=message.getMessage();
		String auth=message.getAuthor();
		String date=message.getCreated();
		long profile_id=message.getProfile_id();
		String sql="insert into message "+"(Profile_id,Message,Author,Created) "+"values('"+profile_id+"','"+msg+"','"+auth+"','"+date+"')";
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
	    Statement myStmt=myConn.createStatement();
	    myStmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
	    ResultSet rs = myStmt.getGeneratedKeys();
	    long id=0;
	    if (rs.next()){
	        id=rs.getLong(1);
	    }

	    Message m=new Message(id,msg,auth,date,profile_id);
	    return m;
	}
	
	public Message updateMessage(Message message) throws SQLException
	{
		long id=message.getMessage_id();
		String msg=message.getMessage();
		String sql="update message set message='"+msg+"' where id='"+id+"'";
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
		Statement myStmt=myConn.createStatement();
		myStmt.executeUpdate(sql);
		
		String sql1="select author from message where id='"+id+"'";
		ResultSet myRs=db.getResultSet(sql1, myConn);
		myRs.next();
		String author=myRs.getString("author");
		String date=new Date().toString();

		Message m=new Message(id,msg,author,date);
		return m;
		
	}
	
	public String deleteMessage(long id) throws SQLException
	{
		String sql="delete from message where id='"+id+"'";
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
		Statement myStmt=myConn.createStatement();
		myStmt.executeUpdate(sql);
		
		return "Succesfully Deleted";
	}
}
