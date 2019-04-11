package com.tcs.tool.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "Project")
public class Project {

	@JsonView(View.Summary.class)
	private long projectId;
	@JsonView(View.Summary.class)
	private String name;
	@JsonView(View.Summary.class)
	private String accountId;
	@JsonView(View.Summary.class)
	private String status;
	@JsonView(View.Summary.class)
	private boolean isActive;
	@JsonView(View.Summary.class)
	private Account account;
	private List<Team> teamList;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
	@SequenceGenerator(name = "project_seq", sequenceName = "project_SEQ")
	@Column(name = "project_id")
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
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

	@ManyToOne
	@JoinColumn(name = "fk_account")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@OneToMany(mappedBy = "project")
	public List<Team> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", accountId=" + accountId + ", status=" + status
				+ ", isActive=" + isActive + ", account=" + account + ", teamList=" + teamList + "]";
	}

}
