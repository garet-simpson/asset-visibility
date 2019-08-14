package com.itemtracer.beans;

import java.util.Date;

public class PartBean {

	private String projectId;
	private String partNumber;
	private String drawingNumber;
	private String partTypeId;
	private String partDescription;
	private String cageCode;
	private String manufacturer;
	private Date timeStamp;
	private String authorUser;
	
	
	public PartBean(String projectId, String partNumber, String drawingNumber, String partTypeId,
			String partDescription, String cageCode, String manufacturer, Date timeStamp, String authorUser) {
		this.projectId = projectId;
		this.partNumber = partNumber;
		this.drawingNumber = drawingNumber;
		this.partTypeId = partTypeId;
		this.partDescription = partDescription;
		this.cageCode = cageCode;
		this.manufacturer = manufacturer;
		this.timeStamp = timeStamp;
		this.authorUser = authorUser;
	}
	
	public PartBean() {
		
	}
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getDrawingNumber() {
		return drawingNumber;
	}
	public void setDrawingNumber(String drawingNumber) {
		this.drawingNumber = drawingNumber;
	}
	public String getPartTypeId() {
		return partTypeId;
	}
	public void setPartTypeId(String partTypeId) {
		this.partTypeId = partTypeId;
	}
	public String getPartDescription() {
		return partDescription;
	}
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	public String getCageCode() {
		return cageCode;
	}
	public void setCageCode(String cageCode) {
		this.cageCode = cageCode;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
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
