package com.itemtracer.beans;

import java.util.Date;

public class DesignConfigurationBean {

	private String project;
	private String assemblyPartNumber;
	private String revision;
	private String referenceDesignator;
	private String alternateCode;
	private String itemPartNumber;
	private int quantity;
	private Date inputDate;
	private String sourceUser;
	
	
	public DesignConfigurationBean(String project, String assemblyPartNumber, String revision,
			String referenceDesignator, String alternateCode, String itemPartNumber, int quantity, Date inputDate,
			String sourceUser) {
		super();
		this.project = project;
		this.assemblyPartNumber = assemblyPartNumber;
		this.revision = revision;
		this.referenceDesignator = referenceDesignator;
		this.alternateCode = alternateCode;
		this.itemPartNumber = itemPartNumber;
		this.quantity = quantity;
		this.inputDate = inputDate;
		this.sourceUser = sourceUser;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getAssemblyPartNumber() {
		return assemblyPartNumber;
	}
	public void setAssemblyPartNumber(String assemblyPartNumber) {
		this.assemblyPartNumber = assemblyPartNumber;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	public String getReferenceDesignator() {
		return referenceDesignator;
	}
	public void setReferenceDesignator(String referenceDesignator) {
		this.referenceDesignator = referenceDesignator;
	}
	public String getAlternateCode() {
		return alternateCode;
	}
	public void setAlternateCode(String alternateCode) {
		this.alternateCode = alternateCode;
	}
	public String getItemPartNumber() {
		return itemPartNumber;
	}
	public void setItemPartNumber(String itemPartNumber) {
		this.itemPartNumber = itemPartNumber;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public String getSourceUser() {
		return sourceUser;
	}
	public void setSourceUser(String sourceUser) {
		this.sourceUser = sourceUser;
	}
	
	
	
}
