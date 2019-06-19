package com.scs.beans;

public class Position {
	private int id;
	private String positionName;
	private int status;
	
	public Position(String positionName) {
		this.positionName=positionName;
	}
	public Position() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
