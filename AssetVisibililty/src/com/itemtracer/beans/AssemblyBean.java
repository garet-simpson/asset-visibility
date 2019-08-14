package com.itemtracer.beans;

import java.util.Date;

public class AssemblyBean {
	
	private String projectId;
	private String parentPartId;
	private String childPartId;
	private String revision;
	private String itemNumber;
	private String referenceDesignator;
	private String alternateCodeId;
	private String quantity;
	private String timeStamp;
	private String authorUser;
	
	public AssemblyBean(String projectId,String parentPartId, String childPartId, String revision,
			String itemNumber,String referenceDesignator,String alternateCodeId,String quantity,String timeStamp,String authorUser) {
		
		this.projectId=projectId;
		this.parentPartId=parentPartId;
		this.childPartId=childPartId;
		this.revision=revision;
		this.itemNumber=itemNumber;
		this.referenceDesignator=referenceDesignator;
		this.alternateCodeId=alternateCodeId;
		this.quantity=quantity;
		this.timeStamp=timeStamp;
		this.authorUser=authorUser;
		
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getParentPartId() {
		return parentPartId;
	}

	public void setParentPartId(String parentPartId) {
		this.parentPartId = parentPartId;
	}

	public String getChildPartId() {
		return childPartId;
	}

	public void setChildPartId(String childPartId) {
		this.childPartId = childPartId;
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

	public String getAlternateCodeId() {
		return alternateCodeId;
	}

	public void setAlternateCodeId(String alternateCodeId) {
		this.alternateCodeId = alternateCodeId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getAuthorUser() {
		return authorUser;
	}

	public void setAuthorUser(String authorUser) {
		this.authorUser = authorUser;
	}
	
	
	

}
