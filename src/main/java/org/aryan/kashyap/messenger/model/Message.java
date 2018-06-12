package org.aryan.kashyap.messenger.model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private long message_id;
	private String message;
	private String created;
	private String author;
	private long profile_id;
	
	public Message(long id, String message, String created, String author, long profile_id) {
		super();
		this.message_id = id;
		this.message = message;
		this.created = created;
		this.author = author;
		this.profile_id = profile_id;
	}

	public long getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(long profile_id) {
		this.profile_id = profile_id;
	}

	public Message(long id, String message, String author,String date) {
		this.message_id = id;
		this.message = message;
		this.author = author;
		this.created=date;
	}
	
	public Message(long id,String message)
	{
		this.message_id = id;
		this.message = message;
	}
	
	public Message(long id,String message,long id2)
	{
		this.message_id = id;
		this.message = message;
		this.profile_id=id2;
	}

	public Message() {
	}

	public long getMessage_id() {
		return message_id;
	}

	public void setMessage_id(long id) {
		this.message_id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
	
	

}
