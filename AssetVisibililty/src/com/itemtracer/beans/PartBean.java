package com.itemtracer.beans;

import java.util.Date;

public class PartBean {

	private int partId;
	private int projectId;
	private String projectName;
	private String partNumber;
	private String drawingNumber;
	private int partTypeId;
	private String partTypeName;
	private String partDescription;
	private String cageCode;
	private String manufacturer;
	private Date timeStamp;
	private int authorUserId;
	private String authorUserName;
	
	
	public PartBean(int partId, int projectId, String partNumber, String drawingNumber, int partTypeId,
			String partDescription, String cageCode, String manufacturer, Date timeStamp, int authorUserId) {
		this.partId = partId;
		this.projectId = projectId;
		this.partNumber = partNumber;
		this.drawingNumber = drawingNumber;
		this.partTypeId = partTypeId;
		this.partDescription = partDescription;
		this.cageCode = cageCode;
		this.manufacturer = manufacturer;
		this.timeStamp = timeStamp;
		this.authorUserId = authorUserId;
	}
	
	public PartBean() {
		
	}
	
	public String validate() {
		
		String infoMessage = null;
		
		if(getPartNumber() == null || getPartNumber().isBlank()) {
			infoMessage = "Sorry, an error occurred!";
		}
		if(getDrawingNumber() == null || getDrawingNumber().isBlank()) {
			infoMessage = "Sorry, an error occurred!";
		}
		if(getPartTypeId() == 0 ) {
			infoMessage = "Sorry, an error occurred!";
		}
		if(getPartDescription() == null || getPartDescription().isBlank()) {
			infoMessage = "Sorry, an error occurred!";
		}
		
	
		return infoMessage;
	}
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
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
	public int getPartTypeId() {
		return partTypeId;
	}
	public void setPartTypeId(int partTypeId) {
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
	public int getAuthorUserId() {
		return authorUserId;
	}
	public void setAuthorUserId(int authorUserId) {
		this.authorUserId = authorUserId;
	}

	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getPartTypeName() {
		return partTypeName;
	}

	public void setPartTypeName(String partTypeName) {
		this.partTypeName = partTypeName;
	}

	public String getAuthorUserName() {
		return authorUserName;
	}

	public void setAuthorUserName(String authorUserName) {
		this.authorUserName = authorUserName;
	}
	
	
	
	
}
