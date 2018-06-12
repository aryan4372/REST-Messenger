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

import org.aryan.kashyap.messenger.model.Likes;
import org.aryan.kashyap.messenger.model.Message;
import org.aryan.kashyap.messenger.service.MessageService;

@Path("/messages")
public class MessageResources {
	
	MessageService m=new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() throws SQLException
	{
		return m.getAllMessages();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId) throws SQLException
	{
		return m.getMessage(messageId);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{messageId}/likes")
	public Likes getLikes(@PathParam("messageId") long messageId) throws SQLException
	{
		return m.getLikes(messageId);
	}
	
	
	/*
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message addMessage(Message message) throws SQLException
	{
		return m.addMessage(message);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId,Message message) throws SQLException
	{
		message.setMessage_id(messageId);
		return m.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteMessage(@PathParam("messageId") long id) throws SQLException
	{
		return m.deleteMessage(id);
	}
	*/
	
	
	

}
