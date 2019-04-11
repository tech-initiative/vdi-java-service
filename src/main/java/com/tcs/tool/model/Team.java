package com.tcs.tool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Team")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "teamId")
public class Team {
	@JsonView(View.Summary.class)
	private long teamId;
	@JsonView(View.Summary.class)
	private String name;
	@JsonView(View.Summary.class)
	private String projectId;
	@JsonView(View.Summary.class)
	private String status;
	@JsonView(View.Summary.class)
	private boolean isActive;
	@JsonView(View.Summary.class)
	private Project project; 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="team_seq")
	@SequenceGenerator(name="team_seq",sequenceName="TEAM_SEQ")
	@Column(name="team_id")
	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	@Column(name = "project_id")
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
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

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", projectId=" + projectId + ", status=" + status
				+ ", isActive=" + isActive + ", project=" + project + "]";
	}
	@ManyToOne
	@JoinColumn(name="fk_team")
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
}
