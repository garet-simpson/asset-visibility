package com.itemtracer.beans;

import java.util.Date;

public class AlternateCodeBean {
	private int alternateCodeId;
	private String alternateCode;
	private Date timeStamp;
	private int authorUserId;
	private String authorUserName;
	
	public AlternateCodeBean(int alternateCodeId, String alternateCode, Date timeStamp, int authorUserId, String authorUserName) {
		this.alternateCodeId=alternateCodeId;
		this.alternateCode=alternateCode;
		this.timeStamp=timeStamp;
		this.authorUserId=authorUserId;
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

	public int getAuthorUserId() {
		return authorUserId;
	}

	public void setAuthorUserId(int authorUserId) {
		this.authorUserId = authorUserId;
	}

	public int getAlternateCodeId() {
		return alternateCodeId;
	}

	public void setAlternateCodeId(int alternateCodeId) {
		this.alternateCodeId = alternateCodeId;
	}

	public String getAuthorUserName() {
		return authorUserName;
	}

	public void setAuthorUserName(String authorUserName) {
		this.authorUserName = authorUserName;
	}
	
	
	
}
