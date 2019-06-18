package com.scs.beans;

import java.sql.Date;

public class Apply {
	private int applyno;
	private int userId;
	private Date applytime;
	private int experiment;
	private int applynum;
	private String cname;
	private User user;
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getApplyno() {
		return applyno;
	}
	public void setApplyno(int applyno) {
		this.applyno = applyno;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getApplytime() {
		return applytime;
	}
	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}
	public int getExperiment() {
		return experiment;
	}
	public void setExperiment(int experiment) {
		this.experiment = experiment;
	}
	public int getApplynum() {
		return applynum;
	}
	public void setApplynum(int applynum) {
		this.applynum = applynum;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
