package com.niit.collaboration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Entity
@Table(name="C_JOBAPPLICATION")
@Component
public class JobApplication extends BaseDomain {
	@Id
	private Long id;
	@Column(name="user_id")
     private String userID;
	@Column(name="job_id")
	private Long jobID;
	private Date dateapplied;
	private String remarks;
	private char status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Long getJobID() {
		return jobID;
	}
	public void setJobID(Long jobID) {
		this.jobID = jobID;
	}
	public Date getDateapplied() {
		return dateapplied;
	}
	public void setDateapplied(Date dateapplied) {
		this.dateapplied = dateapplied;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	
}
