package com.itemtracer.beans;

import java.util.Date;

public class ProjectUserSummaryBean {
	
	private String userName;
	private String firstName;
	private String lastName;
	private String projectName;
	private String projectDescription;
	private String projectAuthority;
	private String authorityDescription;

	
	public ProjectUserSummaryBean() {
		
	}


	public ProjectUserSummaryBean(String userName, String firstName, String lastName, String projectName,
			String projectDescription, String projectAuthority, String authorityDescription) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectAuthority = projectAuthority;
		this.authorityDescription=authorityDescription;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public String getProjectAuthority() {
		return projectAuthority;
	}


	public void setProjectAuthority(String projectAuthority) {
		this.projectAuthority = projectAuthority;
	}


	public String getAuthorityDescription() {
		return authorityDescription;
	}


	public void setAuthorityDescription(String authorityDescription) {
		this.authorityDescription = authorityDescription;
	}

	
	
	
	

}
