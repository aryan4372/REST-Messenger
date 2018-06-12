package org.aryan.kashyap.messenger.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.aryan.kashyap.messenger.model.Comments;
import org.aryan.kashyap.messenger.model.Likes;
import org.aryan.kashyap.messenger.model.Message;
import org.aryan.kashyap.messenger.model.Profile;
import org.aryan.kashyap.messenger.service.MessageService;
import org.aryan.kashyap.messenger.service.ProfileService;

@Path("/profiles")

public class ProfileResource {
	
	ProfileService p=new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Profile> getProfiles() throws SQLException
	{
		return p.getAllProfiles();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Profile addProfile(Profile profile) throws SQLException
	{
		return p.addProfile(profile);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{profileId}")
	public Profile getProfile(@PathParam("profileId") long profileId) throws SQLException
	{
		return p.getProfile(profileId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	@Path("/{profileId}/message")
	public Message addMessage(@PathParam("profileId") long profileId,Message message) throws SQLException
	{
		return p.addMessage(profileId,message);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{profileId}/message")
	public List<Message> getAllMessages(@PathParam("profileId") long profileId) throws SQLException
	{
		return p.getAllMessages(profileId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{profileId}/message/{messageId}")
	public Likes like(@PathParam("profileId") long profileId,@PathParam("messageId") long messageId) throws SQLException
	{
		return p.like(profileId,messageId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{profileId}/message/{messageId}/comment")
	public Comments comment(@PathParam("profileId") long profileId,@PathParam("messageId") long messageId,Comments comment) throws SQLException
	{
		return p.comment(profileId,messageId,comment);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{profileId}/message/{messageId}/comments")
	public List<Comments> getComments(@PathParam("profileId") long profileId,@PathParam("messageId") long messageId) throws SQLException
	{
		return p.getComments(profileId,messageId);
	}
	
	
	
	

}
