package com.itemtracer.beans;

import java.util.Date;

public class MovementTypeBean {
	
	private String movementType;
	private Date timeStamp;
	private String authorUser;
	
	
	public MovementTypeBean(String movementType, Date timeStamp, String authorUser) {

		
		this.movementType = movementType;
		this.timeStamp = timeStamp;
		this.authorUser = authorUser;
	}
	
	public MovementTypeBean() {
		
	}

	public String getMovementType() {
		return movementType;
	}

	public void setMovementType(String movementType) {
		this.movementType = movementType;
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
