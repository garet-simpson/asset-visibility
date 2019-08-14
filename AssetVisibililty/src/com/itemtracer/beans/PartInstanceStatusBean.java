package com.itemtracer.beans;

import java.util.Date;

public class PartInstanceStatusBean {
	
	private String projectId;
	private String movementId;
	private String partInstanceId;
	private String statusId;
	private Date timeStamp;
	private String authorUser;
	
	
	public PartInstanceStatusBean(String projectId, String movementId, String partInstanceId, String statusId,
			Date timeStamp, String authorUser) {
		this.projectId = projectId;
		this.movementId = movementId;
		this.partInstanceId = partInstanceId;
		this.statusId = statusId;
		this.timeStamp = timeStamp;
		this.authorUser = authorUser;
	}
	
	public PartInstanceStatusBean() {
		
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

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
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
