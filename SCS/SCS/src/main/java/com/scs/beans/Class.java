package com.scs.beans;

public class Class {
	private int id;
	private String classnameString;
	private String classteacher;
	private int Grade;
	private int Num;
	
	public Class(String classnameString) {
		this.classnameString=classnameString;
	}
	public Class() {		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public String getClassnameString() {
		return classnameString;
	}
	public void setClassnameString(String classnameString) {
		this.classnameString = classnameString;
	}
	public String getClassteacher() {
		return classteacher;
	}
	public void setClassteacher(String classteacher) {
		this.classteacher = classteacher;
	}
	public int getGrade() {
		return Grade;
	}
	public void setGrade(int grade) {
		Grade = grade;
	}
	public int getNum() {
		return Num;
	}
	public void setNum(int num) {
		Num = num;
	}
}
