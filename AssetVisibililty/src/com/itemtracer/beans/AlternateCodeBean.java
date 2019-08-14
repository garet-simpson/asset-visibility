package com.itemtracer.beans;

import java.util.Date;

public class AlternateCodeBean {
	private String alternateCode;
	private Date timeStamp;
	private String authorUser;
	
	public AlternateCodeBean(String alternateCode, Date timeStamp, String authorUser) {
		this.alternateCode=alternateCode;
		this.timeStamp=timeStamp;
		this.authorUser=authorUser;
	}

	public AlternateCodeBean() {
		
	}

	public String getAlternateCode() {
		return alternateCode;
	}

	public void setAlternateCode(String alternateCode) {
		this.alternateCode = alternateCode;
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
