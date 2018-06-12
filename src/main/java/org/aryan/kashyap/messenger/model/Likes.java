package org.aryan.kashyap.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Likes {
	
	private long Profile_id;
	private long Message_id;
	private String UserName;
	public Likes(long profile_id, long message_id, String userName) {
		super();
		Profile_id = profile_id;
		Message_id = message_id;
		UserName = userName;
	}
	
	public Likes()
	{}
	
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
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	
	
	

}
