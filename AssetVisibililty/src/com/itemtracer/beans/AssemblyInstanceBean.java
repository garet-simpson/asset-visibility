package com.itemtracer.beans;

import java.util.Date;

public class AssemblyInstanceBean {
	
	private String projectId;
	private String movementId;
	private String assemblyId;
	private String parentPartIntanceId;
	private String childPartInstanceId;
	private String quantityAssigned;
	private Date timeStamp;
	private String authorUser;
	
	public AssemblyInstanceBean(String projectId, String movementId, String assemblyId, String parentPartIntanceId,
			String childPartInstanceId, String quantityAssigned, Date timeStamp, String authorUser) {
		this.projectId = projectId;
		this.movementId = movementId;
		this.assemblyId = assemblyId;
		this.parentPartIntanceId = parentPartIntanceId;
		this.childPartInstanceId = childPartInstanceId;
		this.quantityAssigned = quantityAssigned;
		this.timeStamp = timeStamp;
		this.authorUser = authorUser;
	}

	public AssemblyInstanceBean() {
		
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

	public String getAssemblyId() {
		return assemblyId;
	}

	public void setAssemblyId(String assemblyId) {
		this.assemblyId = assemblyId;
	}

	public String getParentPartIntanceId() {
		return parentPartIntanceId;
	}

	public void setParentPartIntanceId(String parentPartIntanceId) {
		this.parentPartIntanceId = parentPartIntanceId;
	}

	public String getChildPartInstanceId() {
		return childPartInstanceId;
	}

	public void setChildPartInstanceId(String childPartInstanceId) {
		this.childPartInstanceId = childPartInstanceId;
	}

	public String getQuantityAssigned() {
		return quantityAssigned;
	}

	public void setQuantityAssigned(String quantityAssigned) {
		this.quantityAssigned = quantityAssigned;
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
