package com.ak.webservices.springhystrixstudentservice.bean;

public class Student {

	private String name;
	private String department;
	public Student(String name, String department) {
		super();
		this.name = name;
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}

