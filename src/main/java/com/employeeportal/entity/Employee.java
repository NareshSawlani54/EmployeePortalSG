package com.employeeportal.entity;

import java.util.Date;

public class Employee {
	
	public enum Gender {
		MALE,FEMALE;
	}
	
	private String mFirstName;
	private String mLastName;
	private Gender mGender;
	private Date mDOB;
	private Department mDepartment;

	public Employee(String firstName,String lastName,Gender gender,Date dob, Department department) {
		this.mFirstName = firstName;
		this.mLastName = lastName;
		this.mGender = gender;
		this.mDOB = dob;
		this.mDepartment = department;
	}

	public Date getDOB() {
		return mDOB;
	}

	public void setDOB(Date mDOB) {
		this.mDOB = mDOB;
	}

	public Department getDepartment() {
		return mDepartment;
	}

	public void setDepartment(Department mDepartment) {
		this.mDepartment = mDepartment;
	}

	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String mLastName) {
		this.mLastName = mLastName;
	}

	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String mName) {
		this.mFirstName = mName;
	}
	
	public Gender getGender() {
		return mGender;
	}

	public void setGender(Gender mGender) {
		this.mGender = mGender;
	}
}
