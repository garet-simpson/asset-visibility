package com.itemtracer.beans;

import java.util.Date;

public class PartInstanceBean {
	
	private String projectId;
	private String movementId;
	private String partId;
	private String serialNumber;
	private String dateCode;
	private String quantity;
	private Date timeStamp;
	private String authorUser;
	
	public PartInstanceBean(String projectId, String movementId, String partId, String serialNumber, String dateCode,
			String quantity, Date timeStamp, String authorUser) {
		this.projectId = projectId;
		this.movementId = movementId;
		this.partId = partId;
		this.serialNumber = serialNumber;
		this.dateCode = dateCode;
		this.quantity = quantity;
		this.timeStamp = timeStamp;
		this.authorUser = authorUser;
	}
	
	public PartInstanceBean() {
		
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

	public String getPartId() {
		return partId;
	}

	public void setPartId(String partId) {
		this.partId = partId;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDateCode() {
		return dateCode;
	}

	public void setDateCode(String dateCode) {
		this.dateCode = dateCode;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
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
