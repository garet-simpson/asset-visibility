package com.itemtracer.beans;

import java.util.Date;

public class OwnerTypeBean {
	
	private String ownerType;
	private Date timeStamp;
	private String authorUser;
	
	
	public OwnerTypeBean(String ownerType, Date timeStamp, String authorUser) {
		this.ownerType = ownerType;
		this.timeStamp = timeStamp;
		this.authorUser = authorUser;
	}
	
	public OwnerTypeBean() {
		
	}

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getAuthorUser() {
		return authorUser;
	}

	public void setAuthorUser(String authorUser) {
		this.authorUser = authorUser;
	}

	
	
}
