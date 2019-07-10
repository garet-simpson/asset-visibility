package com.itemtracer.beans;

import java.util.Date;

public class UserBean {
	
	private int userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private Date timeStamp;
	private int authorUserId;
	
	public UserBean(int userId, String userName, String password, String firstName, String lastName, String email, Date timeStamp, int authorUserId) {
		this.userId=userId;
		this.userName=userName;
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.timeStamp=timeStamp;
		this.authorUserId=authorUserId;
	}

	public UserBean() {
		
	}
	
	public String validate() {
		
		String infoMessage = null;
		
		if(getUserName() == null || getUserName().isBlank()) {
			infoMessage = "Sorry, an error occurred!";
		}
		if(getPassword() == null || getPassword().isBlank()) {
			infoMessage = "Sorry, an error occurred!";
		}
		if(getFirstName() == null || getFirstName().isBlank()) {
			infoMessage = "Sorry, an error occurred!";
		}
		if(getLastName() == null || getLastName().isBlank()) {
			infoMessage = "Sorry, an error occurred!";
		}
		if(getEmail() == null || getEmail().isBlank()) {
			infoMessage = "Sorry, an error occurred!";
		}
	
		return infoMessage;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

}
