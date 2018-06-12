package org.aryan.kashyap.messenger.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.aryan.kashyap.messenger.Database.DbConnection;
import org.aryan.kashyap.messenger.model.Likes;
import org.aryan.kashyap.messenger.model.Message;

public class LikeServices {

	public DbConnection db;
	
	public List<Likes> getAllLikes() throws SQLException
	{
		List<Likes> list=new ArrayList<>();
		db=new DbConnection();
		Connection myConn=DbConnection.setDbConnection();
		String sql="select * from likes";
		ResultSet myRs=db.getResultSet(sql, myConn);
		
		while(myRs.next())
		{
			String id1=myRs.getString("Message_id");
			String message=myRs.getString("UserName");
			String id2=myRs.getString("Profile_id");
			long id3=Long.parseLong(id2);
			long id=Long.parseLong(id1);
			Likes m=new Likes(id3,id,message);
			list.add(m);
		}
		return list;
		
	}
	
}
