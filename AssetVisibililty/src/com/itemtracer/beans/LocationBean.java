package com.itemtracer.beans;

import java.util.Date;

public class LocationBean {
	
	private String projectId;
	private String locationName;
	private String company;
	private String building;
	private String department;
	private String address;
	private String city;
	private String state;
	private String zip;
	private Date timeStamp;
	private String authorUser;
	
	public LocationBean(String projectId, String locationName, String company, String building, String department,
			String address, String city, String state, String zip, Date timeStamp, String authorUser) {

		this.projectId = projectId;
		this.locationName = locationName;
		this.company = company;
		this.building = building;
		this.department = department;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.timeStamp = timeStamp;
		this.authorUser = authorUser;
	}
	
	public LocationBean() {
		
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
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
