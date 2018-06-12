package org.aryan.kashyap.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comments {
	private long Profile_id;
	private long Message_id;
	private String comment;
	
	public Comments(){}
	
	public Comments(long profile_id,long message_id,String comment)
	{
		this.Profile_id=profile_id;
		this.Message_id=message_id;
		this.comment=comment;
	}
	
	public Comments(String comment)
	{
		this.comment=comment;
	}

	public long getProfile_id() {
		return Profile_id;
	}

	public void setProfile_id(long profile_id) {
		Profile_id = profile_id;
	}

	public long getMessage_id() {
		return Message_id;
	}

	public void setMessage_id(long message_id) {
		Message_id = message_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
