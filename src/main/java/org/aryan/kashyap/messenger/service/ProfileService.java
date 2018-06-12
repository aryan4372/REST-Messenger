package org.aryan.kashyap.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.sql.*;
import java.util.List;
import org.aryan.kashyap.messenger.Database.DbConnection;
import org.aryan.kashyap.messenger.model.Comments;
import org.aryan.kashyap.messenger.model.Likes;
import org.aryan.kashyap.messenger.model.Message;
import org.aryan.kashyap.messenger.model.Profile;

public class ProfileService {
	
	public DbConnection db;
	
	public  List<Profile> getAllProfiles() throws SQLException
	{
		
		List<Profile> list=new ArrayList<>();
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
		String sql="select * from profile";
		ResultSet myRs=db.getResultSet(sql, myConn);
		
		while(myRs.next())
		{
			String id=myRs.getString("Profile_id");
			String User_Name=myRs.getString("UserName");
			long id1=Long.parseLong(id);
			Profile m=new Profile(id1,User_Name);
			list.add(m);
		}
		return list;
	}
	
	public Profile addProfile(Profile profile) throws SQLException
	{
		String profile_name=profile.getProfile_name();
		String first_name=profile.getFirst_name();
		String last_name=profile.getLast_name();
		String date=new Date().toString();
		String sql="insert into profile "+"(First_Name,Last_Name,UserName,Created) "+"values('"+first_name+"','"+last_name+"','"+profile_name+"','"+date+"')";
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
	    Statement myStmt=myConn.createStatement();
	    myStmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
	    ResultSet rs = myStmt.getGeneratedKeys();
	    long id=0;
	    if (rs.next()){
	        id=rs.getLong(1);
	    }

	    Profile m=new Profile(id,first_name,last_name,profile_name,date);
	    return m;
	}
	
	public Profile getProfile(long id) throws SQLException
	{
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
		String sql="select * from profile where Profile_id='"+id+"'";
		ResultSet myRs=db.getResultSet(sql, myConn);
		while(myRs.next())
		{
			String first_name=myRs.getString("First_Name");
			String last_name=myRs.getString("Last_Name");
			String profile_name=myRs.getString("UserName");
			String date=myRs.getString("Created");
			Profile m=new Profile(id,first_name,last_name,profile_name,date);
			return m;
		}
		
		return new Profile(0,"error","error","error","error");
	}
	
	public Message addMessage(long id,Message message) throws SQLException
	{
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
		String sql="select * from profile where Profile_id='"+id+"'";
		ResultSet myRs=db.getResultSet(sql, myConn);
		String author;
		while(myRs.next())
		{
			author=myRs.getString("UserName");
			message.setAuthor(author);
		}
		message.setProfile_id(id);
		String date=new Date().toString();
		message.setCreated(date);
		MessageService ms=new MessageService();
		return ms.addMessage(message);	
	}
	
	public  List<Message> getAllMessages(long profileId) throws SQLException
	{
		
		List<Message> list=new ArrayList<>();
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
		String sql="select * from message";
		ResultSet myRs=db.getResultSet(sql, myConn);
		
		while(myRs.next())
		{
			String id1=myRs.getString("Message_id");
			String message=myRs.getString("Message");
			String id2=myRs.getString("Profile_id");
			long id=Long.parseLong(id1);
			long id3=Long.parseLong(id2);
			if(id3!=profileId)
			{
			Message m=new Message(id,message,id3);
			list.add(m);
			}
		}
		return list;
	}
	
	public Likes like(long profileId,long messageId) throws SQLException
	{
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
		String sql1="select UserName from profile where Profile_id='"+profileId+"'";
		ResultSet myRs=db.getResultSet(sql1, myConn);
		myRs.next();
		String author=myRs.getString("UserName");
		String sql="insert into Likes (Profile_id,Message_id,UserName) values('"+profileId+"','"+messageId+"','"+author+"')";
		Statement myStmt=myConn.createStatement();
	    myStmt.executeUpdate(sql);
	    Likes l=new Likes(profileId,messageId,author);
	    return l;
	}
	
	public Comments comment(long profileId,long messageId,Comments comment) throws SQLException
	{
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
		String sql1="insert into comments "+"(Message_id,Profile_id,comment) "+"values('"+messageId+"','"+profileId+"','"+comment.getComment()+"')";
		Statement myStmt=myConn.createStatement();
	    myStmt.executeUpdate(sql1);
		String cmt=comment.getComment();
		return new Comments(profileId,messageId,cmt);
		
	}
	
	public List<Comments> getComments(long profileId,long messageId) throws SQLException
	{
		List<Comments> al=new ArrayList<Comments>();
		String sql="select comment from comments where Profile_id='"+profileId+"'"+"and Message_id='"+messageId+"'";
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
		ResultSet myRs=db.getResultSet(sql, myConn);
		while(myRs.next())
		{
			Comments c=new Comments(profileId,messageId,myRs.getString("comment"));
			al.add(c);
		}
		return al;
	}

}
