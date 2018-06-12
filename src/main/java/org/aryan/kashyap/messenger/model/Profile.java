package org.aryan.kashyap.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	
	private long id;
	private String first_name;
	private String last_name;
	private String profile_name;
	private String created;
	
	public Profile()
	{}
	
	public Profile(String fname,String lname,String pname)
	{
		this.first_name=fname;
		this.last_name=lname;
		this.profile_name=pname;
	}
	
	public Profile(long id,String pname)
	{
		this.id=id;
		this.profile_name=pname;
	}
	
	public Profile(long id,String fname,String lname,String pname,String date)
	{
		this.id=id;
		this.first_name=fname;
		this.last_name=lname;
		this.profile_name=pname;
		this.created=date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getProfile_name() {
		return profile_name;
	}

	public void setProfile_name(String profile_name) {
		this.profile_name = profile_name;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
}
