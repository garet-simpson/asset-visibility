package com.itemtracer.beans;

import java.util.Date;

public class MovementBean {

	private String projectId;
	private String movementTypeId;
	private String partInstanceId;
	private String currentAssemblyInstanceId;
	private String currentPartInstanceLocationId;
	private String currentPartInstanceStatusId;
	private String currentPartInstanceOwnerId;
	private String note;
	private String attachment;
	private Date timeStamp;
	private String authorUser;
	
	public MovementBean(String projectId, String movementTypeId, String partInstanceId,
			String currentAssemblyInstanceId, String currentPartInstanceLocationId, String currentPartInstanceStatusId,
			String currentPartInstanceOwnerId, String note, String attachment, Date timeStamp, String authorUser) {

		this.projectId = projectId;
		this.movementTypeId = movementTypeId;
		this.partInstanceId = partInstanceId;
		this.currentAssemblyInstanceId = currentAssemblyInstanceId;
		this.currentPartInstanceLocationId = currentPartInstanceLocationId;
		this.currentPartInstanceStatusId = currentPartInstanceStatusId;
		this.currentPartInstanceOwnerId = currentPartInstanceOwnerId;
		this.note = note;
		this.attachment = attachment;
		this.timeStamp = timeStamp;
		this.authorUser = authorUser;
	}
	
	public MovementBean() {
		
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getMovementTypeId() {
		return movementTypeId;
	}

	public void setMovementTypeId(String movementTypeId) {
		this.movementTypeId = movementTypeId;
	}

	public String getPartInstanceId() {
		return partInstanceId;
	}

	public void setPartInstanceId(String partInstanceId) {
		this.partInstanceId = partInstanceId;
	}

	public String getCurrentAssemblyInstanceId() {
		return currentAssemblyInstanceId;
	}

	public void setCurrentAssemblyInstanceId(String currentAssemblyInstanceId) {
		this.currentAssemblyInstanceId = currentAssemblyInstanceId;
	}

	public String getCurrentPartInstanceLocationId() {
		return currentPartInstanceLocationId;
	}

	public void setCurrentPartInstanceLocationId(String currentPartInstanceLocationId) {
		this.currentPartInstanceLocationId = currentPartInstanceLocationId;
	}

	public String getCurrentPartInstanceStatusId() {
		return currentPartInstanceStatusId;
	}

	public void setCurrentPartInstanceStatusId(String currentPartInstanceStatusId) {
		this.currentPartInstanceStatusId = currentPartInstanceStatusId;
	}

	public String getCurrentPartInstanceOwnerId() {
		return currentPartInstanceOwnerId;
	}

	public void setCurrentPartInstanceOwnerId(String currentPartInstanceOwnerId) {
		this.currentPartInstanceOwnerId = currentPartInstanceOwnerId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
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
