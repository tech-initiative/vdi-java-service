package com.tcs.tool.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	private long tcsEmployeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String clientId;
	private String locationId;
	private Date onboardingDate;
	private Date registrationDate;
	private Date last_login_time;
	private String status;
	private boolean isActive;
	private boolean isAdmin;
	private boolean isAccountManager;
	private boolean isProjectManager;

	@Id
	@Column(name = "tcs_employee_id")
	public long getTcsEmployeeId() {
		return tcsEmployeeId;
	}

	public void setTcsEmployeeId(long tcsEmployeeId) {
		this.tcsEmployeeId = tcsEmployeeId;
	}
	
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "client_id")
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	@Column(name = "location_id")
	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	@Column(name = "onboarding_date")
	public Date getOnboardingDate() {
		return onboardingDate;
	}

	public void setOnboardingDate(Date onboardingDate) {
		this.onboardingDate = onboardingDate;
	}
	@Column(name = "registration_date") 
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	@Column(name = "last_login_time") 
	public Date getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	@Column(name = "status") 
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "is_active")  
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Column(name="is_admin")
	public boolean getIsAdmin() {
		return isAdmin;
	}
	
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Column(name="is_account_manager")
	public boolean getIsAccountManager() {
		return isAccountManager;
	}

	public void setIsAccountManager(boolean isAccountManager) {
		this.isAccountManager = isAccountManager;
	}

	@Column(name="is_project_manager")
	public boolean getIsProjectManager() {
		return isProjectManager;
	}

	public void setIsProjectManager(boolean isProjectManager) {
		this.isProjectManager = isProjectManager;
	}
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", tcsEmployeeId=" + tcsEmployeeId + ", clientId=" + clientId
				+ ", locationId=" + locationId + ", onboardingDate=" + onboardingDate + ", registrationDate="
				+ registrationDate + ", last_login_time=" + last_login_time + ", status=" + status + ", isActive="
				+ isActive + "]";
	}

}
