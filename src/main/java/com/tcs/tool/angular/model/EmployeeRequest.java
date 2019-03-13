package com.tcs.tool.angular.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {

	@JsonProperty("tcs_employee_id")
	private String employeeId;
	
	private String password;
	
	@JsonProperty("is_admin")
	private boolean isAdmin;
	
	@JsonProperty("email_id")
	private String emailId;
	
	@JsonProperty("user_name")
	private String userName;
	
	@JsonProperty("location_id")
	private String locationId;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
