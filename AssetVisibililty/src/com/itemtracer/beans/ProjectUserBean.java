package com.itemtracer.beans;

import java.util.Date;

public class ProjectUserBean {
	
	private String projectName;
	private String projectDescription;
	private Date timeStamp;
	private String authorUser;
	
	public ProjectUserBean(String projectName, String projectDescription, Date timeStamp, String authorUser) {
		this.projectName=projectName;
		this.projectDescription=projectDescription;
		this.timeStamp=timeStamp;
		this.authorUser=authorUser;
				
	}
	
	public ProjectUserBean() {
		
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
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
