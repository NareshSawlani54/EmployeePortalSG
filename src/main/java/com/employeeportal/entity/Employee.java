package com.employeeportal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Column(name = "id")
	private long id;
	
	@Column(name = "first_name")
	private String mFirstName;
	
	@Column(name = "last_name")
	private String mLastName;
	
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender mGender;
	
	@Column(name = "dob")
	private Date mDOB;
	
	@ManyToOne
	@JoinColumn(name = "dept_id", nullable = true)
	private Department mDepartment;
	
	public Employee() {}

	public Employee(String firstName,String lastName,Gender gender,Date dob, Department department) {
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

	@JsonProperty("dob")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public Date getDOB() {
		return mDOB;
	}

	@JsonProperty("dob")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
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
