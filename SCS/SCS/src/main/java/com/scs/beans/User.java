package com.scs.beans;


public class User {
	private int id;
	private String password;
	private String workno;
	private String name;
	private String sex;
	private int phone;
	private String college;
	private int positionId;
	private int status;
	private int classId;
	
    private Position position;
    private String positionName;
    
    private Class class1;
    private String classnameString;
    
    public Class getClass1() {
		return class1;
	}
	public void setClass1(Class class1) {
		this.class1 = class1;
	}
	public String getClassnameString() {
		return classnameString;
	}
	public void setClassnameString(String classnameString) {
		this.classnameString = classnameString;
	}
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
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	
	public User(String name) {
		this.name=name;
	}
	public User() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWorkno() {
		return workno;
	}
	public void setWorkno(String workno) {
		this.workno = workno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
}
