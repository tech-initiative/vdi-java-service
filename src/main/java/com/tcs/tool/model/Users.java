package com.tcs.tool.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String tcsEmployeeId;
	private String clientId;
	private String locationId;
	private Date onboardingDate;
	private Date registrationDate;
	private Date last_login_time;
	private String status;
	private boolean isActive;
	private boolean isAdmin;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Column(name = "tcs_employee_id")
	public String getTcsEmployeeId() {
		return tcsEmployeeId;
	}

	public void setTcsEmployeeId(String tcsEmployeeId) {
		this.tcsEmployeeId = tcsEmployeeId;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", tcsEmployeeId=" + tcsEmployeeId + ", clientId=" + clientId
				+ ", locationId=" + locationId + ", onboardingDate=" + onboardingDate + ", registrationDate="
				+ registrationDate + ", last_login_time=" + last_login_time + ", status=" + status + ", isActive="
				+ isActive + "]";
	}

}
