package com.tcs.tool.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VdiUsageProject")
public class VdiUsageProject {

	private long id;
	private String projectId;
	private Date startDate;
	private Date endDate;
	private boolean status;
	private String coreHr;
	private String appHr;
	private String inactiveHr;
	private String leaveHr;
	private String totalVdiHr;
	private String totalHeadCount;
	private String avgVdiHr;
	private String durationType;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "projectId")
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Column(name = "startDate")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "endDate")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "isStatus")
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Column(name = "coreHr")
	public String getCoreHr() {
		return coreHr;
	}

	public void setCoreHr(String coreHr) {
		this.coreHr = coreHr;
	}

	@Column(name = "appHr")
	public String getAppHr() {
		return appHr;
	}

	public void setAppHr(String appHr) {
		this.appHr = appHr;
	}

	@Column(name = "leaveHr")

	public String getLeaveHr() {
		return leaveHr;
	}

	public void setLeaveHr(String leaveHr) {
		this.leaveHr = leaveHr;
	}

	@Column(name = "inactiveHr")
	public String getInactiveHr() {
		return inactiveHr;
	}

	public void setInactiveHr(String inactiveHr) {
		this.inactiveHr = inactiveHr;
	}

	@Column(name = "totalVdiHr")
	public String getTotalVdiHr() {
		return totalVdiHr;
	}

	public void setTotalVdiHr(String totalVdiHr) {
		this.totalVdiHr = totalVdiHr;
	}

	@Column(name = "totalHeadCount")
	public String getTotalHeadCount() {
		return totalHeadCount;
	}

	public void setTotalHeadCount(String totalHeadCount) {
		this.totalHeadCount = totalHeadCount;
	}

	@Column(name = "avgVdiHr")
	public String getAvgVdiHr() {
		return avgVdiHr;
	}

	public void setAvgVdiHr(String avgVdiHr) {
		this.avgVdiHr = avgVdiHr;
	}

	@Column(name = "durationType")
	public String getDurationType() {
		return durationType;
	}

	public void setDurationType(String durationType) {
		this.durationType = durationType;
	}

	@Override
	public String toString() {
		return "VdiUsage [id=" + id + ", projectId=" + projectId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", status=" + status + ", coreHr=" + coreHr + ", appHr=" + appHr + ", inactiveHr=" + inactiveHr
				+ ", leaveHr=" + leaveHr + ", totalVdiHr=" + totalVdiHr + ", totalHeadCount=" + totalHeadCount
				+ ", avgVdiHr=" + avgVdiHr + ", durationType=" + durationType + "]";
	}

}
