package com.employeeportal.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
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
	
	@JsonProperty("id")
	public long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty("dob")
	public Date getDOB() {
		return mDOB;
	}

	@JsonProperty("dob")
	public void setDOB(Date mDOB) {
		this.mDOB = mDOB;
	}

	@JsonProperty("department")
	public Department getDepartment() {
		return mDepartment;
	}

	@JsonProperty("department")
	public void setDepartment(Department mDepartment) {
		this.mDepartment = mDepartment;
	}

	@JsonProperty("lastName")
	public String getLastName() {
		return mLastName;
	}

	@JsonProperty("lastName")
	public void setLastName(String mLastName) {
		this.mLastName = mLastName;
	}

	@JsonProperty("firstName")
	public String getFirstName() {
		return mFirstName;
	}

	@JsonProperty("firstName")
	public void setFirstName(String mName) {
		this.mFirstName = mName;
	}
	
	@JsonProperty("gender")
	public Gender getGender() {
		return mGender;
	}

	@JsonProperty("gender")
	public void setGender(Gender mGender) {
		this.mGender = mGender;
	}
}
