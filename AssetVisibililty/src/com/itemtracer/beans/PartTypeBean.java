package com.itemtracer.beans;

import java.util.Date;

public class PartTypeBean {

	private String partType;
	private Date timeStamp;
	private String authorUser;
	
	
	public PartTypeBean(String partType, Date timeStamp, String authorUser) {

		this.partType = partType;
		this.timeStamp = timeStamp;
		this.authorUser = authorUser;
	}
	
	
	public PartTypeBean() {

	}


	public String getPartType() {
		return partType;
	}


	public void setPartType(String partType) {
		this.partType = partType;
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
