package com.tcs.tool.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Project")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Project {

	private long id;
	private String name;
	private String accountId;
	private String status;
	private boolean isActive;
	private List<Team> teamList;
	private List<Employee> ProjectManager;
	private Account account;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "account_id")
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "is_active ")
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@OneToMany(cascade = CascadeType.ALL)
	/*
	 * @JoinTable(name = "team", joinColumns = { @JoinColumn(name = "teamId") })
	 */
	public List<Team> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}

	@OneToMany(cascade = CascadeType.ALL)
	public List<Employee> getProjectManager() {
		return ProjectManager;
	}

	public void setProjectManager(List<Employee> projectManager) {
		ProjectManager = projectManager;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "acc_id")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", accountId=" + accountId + ", status=" + status
				+ ", isActive=" + isActive + ", teamList=" + teamList + ", ProjectManager=" + ProjectManager
				+ ", account=" + account + "]";
	}

}
