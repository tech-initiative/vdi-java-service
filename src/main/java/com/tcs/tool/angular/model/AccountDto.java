package com.tcs.tool.angular.model;

import java.util.List;

import com.tcs.tool.model.Employee;

public class AccountDto {

	private long accId;
	private String name;
	private String locationId;
	
	private List<ProjectDto> projectList;
	
	private List<Employee> accountManagerList;
	
	
	public long getAccId() {
		return accId;
	}
	public void setAccId(long accId) {
		this.accId = accId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public List<ProjectDto> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<ProjectDto> projectList) {
		this.projectList = projectList;
	}
	public List<Employee> getAccountManager() {
		return accountManagerList;
	}
	public void setAccountManager(List<Employee> accountManager) {
		this.accountManagerList = accountManager;
	}
	private String status;
	private boolean isActive;
}
