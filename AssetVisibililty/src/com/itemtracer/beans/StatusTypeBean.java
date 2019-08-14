package com.itemtracer.beans;

import java.util.Date;

public class StatusTypeBean {

	private String statusType;
	private Date timeStamp;
	private String authorUser;
	
	
	public StatusTypeBean(String statusType, Date timeStamp, String authorUser) {

		this.statusType = statusType;
		this.timeStamp = timeStamp;
		this.authorUser = authorUser;
	}
	
	public StatusTypeBean() {

	}
	
	
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
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
