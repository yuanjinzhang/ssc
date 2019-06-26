package com.scs.beans;

public class SelectCourses {
	private int userId;
	private int cno;
	private double score;
	private int status;
	//¿Î³ÌÃû
	private Course course;
	private String cname;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getCname() {
		return cname;
	}
	public void setCanme(String cname) {
		this.cname = cname;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
