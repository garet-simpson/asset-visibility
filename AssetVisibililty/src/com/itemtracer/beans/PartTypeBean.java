package com.itemtracer.beans;

import java.util.Date;

public class PartTypeBean {

	private int partTypeId;
	private String partType;
	private Date timeStamp;
	private int authorUserId;
	
	
	public PartTypeBean(int partTypeId, String partType, Date timeStamp, int authorUserId) {
		
		this.partTypeId = partTypeId;
		this.partType = partType;
		this.timeStamp = timeStamp;
		this.authorUserId = authorUserId;
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


	public int getAuthorUserId() {
		return authorUserId;
	}


	public void setAuthorUserId(int authorUserId) {
		this.authorUserId = authorUserId;
	}


	public int getPartTypeId() {
		return partTypeId;
	}


	public void setPartTypeId(int partTypeId) {
		this.partTypeId = partTypeId;
	}


	
	
	
	
}
