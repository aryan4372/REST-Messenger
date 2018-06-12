package org.aryan.kashyap.messenger.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.aryan.kashyap.messenger.model.Likes;
import org.aryan.kashyap.messenger.service.LikeServices;

@Path("/likes")
public class LikeResources {
	
	LikeServices ls=new LikeServices();
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Likes> getAllLikes() throws SQLException
	{
		return ls.getAllLikes();
	}

}
