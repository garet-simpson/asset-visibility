package com.itemtracer.beans;

import java.util.Date;

public class AssemblyBean {
	
	private int assemblyId;
	private int projectId;
	private String projectName;
	private int parentPartId;
	private String parentPartNumber;
	private int childPartId;
	private String childPartNumber;
	private String revision;
	private String itemNumber;
	private String referenceDesignator;
	private int alternateCodeId;
	private String alternateCode;
	private String quantity;
	private Date timeStamp;
	private int authorUserId;
	private String authorUserName;
	
	
	public AssemblyBean(int projectId, String projectName, int parentPartId, String parentPartNumber, int childPartId,
			String childPartNumber, String revision, String itemNumber, String referenceDesignator, int alternateCodeId,
			String alternateCode, String quantity, Date timeStamp, int authorUserId, String authorUserName) {

		this.projectId = projectId;
		this.projectName = projectName;
		this.parentPartId = parentPartId;
		this.parentPartNumber = parentPartNumber;
		this.childPartId = childPartId;
		this.childPartNumber = childPartNumber;
		this.revision = revision;
		this.itemNumber = itemNumber;
		this.referenceDesignator = referenceDesignator;
		this.alternateCodeId = alternateCodeId;
		this.alternateCode = alternateCode;
		this.quantity = quantity;
		this.timeStamp = timeStamp;
		this.authorUserId = authorUserId;
		this.authorUserName = authorUserName;

	}
	
	public AssemblyBean() {
		
	}
	
	
public String validate() {
		
		String infoMessage = null;
		
		if(getParentPartId() == 0) {
			infoMessage = "Sorry, an error occurred!";
		}
		if(getChildPartId() == 0) {
			infoMessage = "Sorry, an error occurred!";
		}
		if(getRevision() == null || getRevision().isBlank()) {
			infoMessage = "Sorry, an error occurred!";
		}
		if(getItemNumber() == null || getItemNumber().isBlank()) {
			infoMessage = "Sorry, an error occurred!";
		}
		if(getAlternateCodeId() == 0) {
			infoMessage = "Sorry, an error occurred!";
		}
		if(getQuantity() == null || getQuantity().isBlank()) {
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getParentPartId() {
		return parentPartId;
	}

	public void setParentPartId(int parentPartId) {
		this.parentPartId = parentPartId;
	}

	public String getParentPartNumber() {
		return parentPartNumber;
	}

	public void setParentPartNumber(String parentPartNumber) {
		this.parentPartNumber = parentPartNumber;
	}

	public int getChildPartId() {
		return childPartId;
	}

	public void setChildPartId(int childPartId) {
		this.childPartId = childPartId;
	}

	public String getChildPartNumber() {
		return childPartNumber;
	}

	public void setChildPartNumber(String childPartNumber) {
		this.childPartNumber = childPartNumber;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getReferenceDesignator() {
		return referenceDesignator;
	}

	public void setReferenceDesignator(String referenceDesignator) {
		this.referenceDesignator = referenceDesignator;
	}

	public int getAlternateCodeId() {
		return alternateCodeId;
	}

	public void setAlternateCodeId(int alternateCodeId) {
		this.alternateCodeId = alternateCodeId;
	}

	public String getAlternateCode() {
		return alternateCode;
	}

	public void setAlternateCode(String alternateCode) {
		this.alternateCode = alternateCode;
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

	public int getAuthorUserId() {
		return authorUserId;
	}

	public void setAuthorUserId(int authorUserId) {
		this.authorUserId = authorUserId;
	}

	public String getAuthorUserName() {
		return authorUserName;
	}

	public void setAuthorUserName(String authorUserName) {
		this.authorUserName = authorUserName;
	}

	public int getAssemblyId() {
		return assemblyId;
	}

	public void setAssemblyId(int assemblyId) {
		this.assemblyId = assemblyId;
	}
	


}
