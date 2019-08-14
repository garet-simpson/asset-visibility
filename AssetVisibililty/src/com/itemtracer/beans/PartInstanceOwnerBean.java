package com.itemtracer.beans;

import java.util.Date;

public class PartInstanceOwnerBean {
	
	private String projectId;
	private String movementId;
	private String partInstanceId;
	private String ownerId;
	private Date timeStamp;
	private String authorUser;
	
	
	public PartInstanceOwnerBean(String projectId, String movementId, String partInstanceId, String ownerId, Date timeStamp,
			String authorUser) {

		this.projectId = projectId;
		this.movementId = movementId;
		this.partInstanceId = partInstanceId;
		this.ownerId = ownerId;
		this.timeStamp = timeStamp;
		this.authorUser = authorUser;
	}
	
	public PartInstanceOwnerBean() {
		
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getMovementId() {
		return movementId;
	}

	public void setMovementId(String movementId) {
		this.movementId = movementId;
	}

	public String getPartInstanceId() {
		return partInstanceId;
	}

	public void setPartInstanceId(String partInstanceId) {
		this.partInstanceId = partInstanceId;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
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
