package com.scs.beans;

import java.sql.Date;

public class Apply {
	private int Applyno;
	private int UserId;
	private Date applytime;
	private int Experiment;
	private int Applynum;
	private String cname;
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getApplyno() {
		return Applyno;
	}
	public void setApplyno(int applyno) {
		Applyno = applyno;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public Date getApplytime() {
		return applytime;
	}
	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}
	public int getExperiment() {
		return Experiment;
	}
	public void setExperiment(int experiment) {
		Experiment = experiment;
	}
	public int getApplynum() {
		return Applynum;
	}
	public void setApplynum(int applynum) {
		Applynum = applynum;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
