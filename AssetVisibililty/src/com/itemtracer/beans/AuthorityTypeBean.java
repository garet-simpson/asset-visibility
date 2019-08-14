package com.itemtracer.beans;

import java.util.Date;

public class AuthorityTypeBean {
	
	private int authorityTypeId;
	private String authorityType;
	private String authorityDescription;
	private Date timeStamp;
	private int authorUser;
	
	
	public AuthorityTypeBean(int authorityTypeId, String authorityType, String authorityDescription, Date timeStamp,
			int authorUser) {

		this.authorityTypeId = authorityTypeId;
		this.authorityType = authorityType;
		this.authorityDescription = authorityDescription;
		this.timeStamp = timeStamp;
		this.authorUser = authorUser;
	}


	public AuthorityTypeBean() {

	}


	public int getAuthorityTypeId() {
		return authorityTypeId;
	}


	public void setAuthorityTypeId(int authorityTypeId) {
		this.authorityTypeId = authorityTypeId;
	}


	public String getAuthorityType() {
		return authorityType;
	}


	public void setAuthorityType(String authorityType) {
		this.authorityType = authorityType;
	}


	public String getAuthorityDescription() {
		return authorityDescription;
	}


	public void setAuthorityDescription(String authorityDescription) {
		this.authorityDescription = authorityDescription;
	}


	public Date getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}


	public int getAuthorUser() {
		return authorUser;
	}


	public void setAuthorUser(int authorUser) {
		this.authorUser = authorUser;
	}
	
	
	
	
}
