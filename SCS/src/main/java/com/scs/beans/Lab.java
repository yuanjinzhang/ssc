package com.scs.beans;

import java.sql.Date;

public class Lab {
	private int Eno;
	private int Cname;
	private String Place;
	private Date Etime;
	private int Cno;
	public int getEno() {
		return Eno;
	}
	public void setEno(int eno) {
		Eno = eno;
	}
	public int getCname() {
		return Cname;
	}
	public void setCname(int cname) {
		Cname = cname;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public Date getEtime() {
		return Etime;
	}
	public void setEtime(Date etime) {
		Etime = etime;
	}
	public int getCno() {
		return Cno;
	}
	public void setCno(int cno) {
		Cno = cno;
	}
	
}
