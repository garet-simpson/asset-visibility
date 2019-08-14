package com.itemtracer.beans;

import java.util.Date;

public class ProjectBean {
	
	private int projectId;
	private String projectName; 
	private String projectDescription;
	private Date timeStamp;
	private int authorUserId;
	
	public ProjectBean(int projectId, String projectName, String projectDescription, Date timeStamp, int authorUserId) {
		this.projectId=projectId;
		this.projectName=projectName;
		this.projectDescription=projectDescription;
		this.timeStamp=timeStamp;
		this.authorUserId=authorUserId;
		
	}
	
	public ProjectBean() {
		
	}
	
	public String validate() {
		
		String infoMessage = null;
		
		if(getProjectName() == null || getProjectName().isBlank()) {
			infoMessage = "Sorry, an error occurred!";
		}
		if(getProjectDescription() == null || getProjectDescription().isBlank()) {
			infoMessage = "Sorry, an error occurred!";
		}
	
		return infoMessage;
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

	public int getAuthorUserId() {
		return authorUserId;
	}

	public void setAuthorUserId(int authorUserId) {
		this.authorUserId = authorUserId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	
	
}
