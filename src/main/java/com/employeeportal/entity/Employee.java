package com.employeeportal.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	public enum Gender {
		MALE,FEMALE;
	}
	
	@Id
	@GeneratedValue
	private long id;
	private String mFirstName;
	private String mLastName;
	private Gender mGender;
	private Date mDOB;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id", nullable = true)
	private Department mDepartment;
	
	public Employee() {}

	public Employee(long id,String firstName,String lastName,Gender gender,Date dob, Department department) {
		this.id = id;
		this.mFirstName = firstName;
		this.mLastName = lastName;
		this.mGender = gender;
		this.mDOB = dob;
		this.mDepartment = department;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
