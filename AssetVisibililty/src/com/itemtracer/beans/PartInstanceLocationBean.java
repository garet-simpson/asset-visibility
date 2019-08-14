package com.itemtracer.beans;

import java.util.Date;

public class PartInstanceLocationBean {
	
	private String projectId;
	private String movementId;
	private String partInstanceId;
	private String originLocationId;
	private String destinationLocationId;
	private Date timeStamp;
	private String authorUser;
	
	public PartInstanceLocationBean(String projectId, String movementId, String partInstanceId, String originLocationId,
			String destinationLocationId, Date timeStamp, String authorUser) {

		this.projectId = projectId;
		this.movementId = movementId;
		this.partInstanceId = partInstanceId;
		this.originLocationId = originLocationId;
		this.destinationLocationId = destinationLocationId;
		this.timeStamp = timeStamp;
		this.authorUser = authorUser;
	}
	
	public PartInstanceLocationBean() {
		
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

	public String getOriginLocationId() {
		return originLocationId;
	}

	public void setOriginLocationId(String originLocationId) {
		this.originLocationId = originLocationId;
	}

	public String getDestinationLocationId() {
		return destinationLocationId;
	}

	public void setDestinationLocationId(String destinationLocationId) {
		this.destinationLocationId = destinationLocationId;
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
