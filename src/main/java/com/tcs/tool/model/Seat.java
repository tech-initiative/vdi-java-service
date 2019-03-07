package com.tcs.tool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Seat")
public class Seat {

	private long id;
	private String seatNo;
	private String odc;
	private boolean is_occupied;
	private String project_id;
	private String user_id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "seat_No")
	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	@Column(name = "odc")
	public String getOdc() {
		return odc;
	}

	public void setOdc(String odc) {
		this.odc = odc;
	}

	@Column(name = "is_occupied")
	public boolean isIs_occupied() {
		return is_occupied;
	}

	public void setIs_occupied(boolean is_occupied) {
		this.is_occupied = is_occupied;
	}
	@Column(name = "project_id")
	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}
	@Column(name = "user_id")
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", seatNo=" + seatNo + ", odc=" + odc + ", is_occupied=" + is_occupied
				+ ", project_id=" + project_id + ", user_id=" + user_id + "]";
	}

}
