package com.tcs.tool.angular.model;

import java.util.List;

import com.tcs.tool.model.Employee;

public class EmployeeAddRequest {

	private Employee employee;
	private boolean isAccountManager;
	private List<String> accountIdList;
	private boolean isProjectManager;
	private List<String> projectIdList;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public boolean getIsAccountManager() {
		return isAccountManager;
	}
	public void setIsAccountManager(boolean isAccountManager) {
		this.isAccountManager = isAccountManager;
	}
	
	public boolean getIsProjectManager() {
		return isProjectManager;
	}
	public void setIsProjectManager(boolean isProjectManager) {
		this.isProjectManager = isProjectManager;
	}
	public List<String> getAccountIdList() {
		return accountIdList;
	}
	public void setAccountIdList(List<String> accountIdList) {
		this.accountIdList = accountIdList;
	}
	public List<String> getProjectIdList() {
		return projectIdList;
	}
	public void setProjectIdList(List<String> projectIdList) {
		this.projectIdList = projectIdList;
	}	
}
