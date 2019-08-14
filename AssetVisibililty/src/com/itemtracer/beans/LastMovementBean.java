package com.itemtracer.beans;

import java.util.Date;


public class LastMovementBean {
	
	private Date timeStamp;
	private String projectName;
	private String movementType;
	private String partDescription;
	private String partInstanceId;
	private String partNumber;
	private String serialNumber;
	private String quantityAssigned;
	private String parentPartNumber;
	private String parentSerialNumber;
	private String originLocationName;
	private String destinationLocationName;
	private String statusType;
	private String ownerName;
	private String note;
	private String attachment;
	private String authorUser;
	
	
	public LastMovementBean(Date timeStamp, String projectName, String movementType, String partDescription, String partInstanceId,
			String partNumber, String serialNumber, String quantityAssigned, String parentPartNumber, String parentSerialNumber, String originLocationName,
			String destinationLocationName, String statusType, String ownerName, String note, String attachment, String authorUser) {

		this.timeStamp = timeStamp;
		this.projectName = projectName;
		this.movementType = movementType;
		this.partDescription = partDescription;
		this.partInstanceId = partInstanceId;
		this.partNumber = partNumber;
		this.serialNumber = serialNumber;
		this.quantityAssigned = quantityAssigned;
		this.parentPartNumber = parentPartNumber;
		this.parentSerialNumber = parentSerialNumber;
		this.originLocationName = originLocationName;
		this.destinationLocationName = destinationLocationName;
		this.statusType = statusType;
		this.ownerName = ownerName;
		this.note = note;
		this.attachment = attachment;
		this.authorUser = authorUser;
	}


	public LastMovementBean() {

	}


	public Date getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getPartDescription() {
		return partDescription;
	}


	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}


	public String getPartInstanceId() {
		return partInstanceId;
	}


	public void setPartInstanceId(String partInstanceId) {
		this.partInstanceId = partInstanceId;
	}


	public String getPartNumber() {
		return partNumber;
	}


	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}


	public String getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getQuantityAssigned() {
		return quantityAssigned;
	}


	public void setQuantityAssigned(String quantityAssigned) {
		this.quantityAssigned = quantityAssigned;
	}


	public String getOriginLocationName() {
		return originLocationName;
	}


	public void setOriginLocationName(String originLocationName) {
		this.originLocationName = originLocationName;
	}


	public String getDestinationLocationName() {
		return destinationLocationName;
	}


	public void setDestinationLocationName(String destinationLocationName) {
		this.destinationLocationName = destinationLocationName;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
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


	public String getAuthorUser() {
		return authorUser;
	}


	public void setAuthorUser(String authorUser) {
		this.authorUser = authorUser;
	}


	public String getMovementType() {
		return movementType;
	}


	public void setMovementType(String movementType) {
		this.movementType = movementType;
	}


	public String getParentPartNumber() {
		return parentPartNumber;
	}


	public void setParentPartNumber(String parentPartNumber) {
		this.parentPartNumber = parentPartNumber;
	}


	public String getParentSerialNumber() {
		return parentSerialNumber;
	}


	public void setParentSerialNumber(String parentSerialNumber) {
		this.parentSerialNumber = parentSerialNumber;
	}


	public String getStatusType() {
		return statusType;
	}


	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	

}
