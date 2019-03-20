package com.tcs.tool.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "Account")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "accId")
public class Account {

	@JsonView(View.Summary.class)
	private long accId;
	@JsonView(View.Summary.class)
	private String name;
	@JsonView(View.Summary.class)
	private String locationId;
	@JsonView(View.Summary.class)
	private String status;
	@JsonView(View.Summary.class)
	private boolean isActive;
	
	private List<Project> projectList;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="acct_seq",sequenceName="ACCT_SEQ")
	@Column(name = "acc_id", nullable = false)
	public long getAccId() {
		return accId;
	}

	public void setAccId(long id) {
		this.accId = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "location_id")
	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "is_active")
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@OneToMany(mappedBy="account")
	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	@Override
	public String toString() {
		return "Account [id=" + accId + ", name=" + name + ", locationId=" + locationId + ", status=" + status
				+ ", isActive=" + isActive + "]";
	}

}
