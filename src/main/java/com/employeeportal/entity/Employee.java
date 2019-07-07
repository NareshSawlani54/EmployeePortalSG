package com.employeeportal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All Details About An Empoyee")
@Entity
public class Employee {
	
	public enum Gender {
		MALE,FEMALE;
	}
	
	@JsonProperty("id")
	@ApiModelProperty(required = false,hidden = true,position = 0)
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@JsonProperty("firstName")
	@ApiModelProperty(value = "First Name Of Empoyee",example = "'Naresh'",position = 1)
	@Column(name = "first_name")
	private String mFirstName;
	
	@JsonProperty("lastName")
	@ApiModelProperty(value = "Last Name Of Empoyee",example = "Sawlani",position = 2)
	@Column(name = "last_name")
	private String mLastName;
	
	@JsonProperty("gender")
	@ApiModelProperty(value = "Gender Of Empoyee", example = "MALE",position = 3)
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender mGender;
	
	@JsonProperty("dob")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@ApiModelProperty(value = "DOB Of Empoyee", notes = "Must be in YYYY-MM-DD Format" , example = "1989-06-23",position = 4)
	@Column(name = "dob")
	private Date mDOB;
	
	@JsonProperty("department")
	@ApiModelProperty(position = 5)
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
	
	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String mName) {
		this.mFirstName = mName;
	}
	
	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String mLastName) {
		this.mLastName = mLastName;
	}

	public Date getDOB() {
		return mDOB;
	}

	public void setDOB(Date mDOB) {
		this.mDOB = mDOB;
	}
	
	public Gender getGender() {
		return mGender;
	}

	public void setGender(Gender mGender) {
		this.mGender = mGender;
	}

	public Department getDepartment() {
		return mDepartment;
	}

	public void setDepartment(Department mDepartment) {
		this.mDepartment = mDepartment;
	}
}
