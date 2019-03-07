package com.tcs.tool.angular.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {

	@JsonProperty("tcs_employee_id")
	private String employeeId;
	private String password;
	private boolean isAdmin;
	
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
	
}
