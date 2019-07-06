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
import springfox.documentation.schema.Example;

@ApiModel(description = "All Details About An Empoyee")
@Entity
public class Employee {
	
	public enum Gender {
		MALE,FEMALE;
	}
	
	@ApiModelProperty(required = false,position = 0)
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@ApiModelProperty(value = "First Name Of Empoyee",example = "'Naresh'",position = 1)
	@Column(name = "first_name")
	private String mFirstName;
	
	@ApiModelProperty(value = "Last Name Of Empoyee",example = "Sawlani",position = 2)
	@Column(name = "last_name")
	private String mLastName;
	
	@ApiModelProperty(value = "Gender Of Empoyee", example = "MALE",position = 3)
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	private Gender mGender;
	
	@ApiModelProperty(value = "DOB Of Empoyee", notes = "Must be in DD-MM-YYYY Format" , example = "23-06-1989",position = 4)
	@Column(name = "dob")
	private Date mDOB;
	
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
	
	@JsonProperty("id")
	public long getId() {
		return id;
	}
	
	@JsonProperty("id")
	public void setId(long id) {
		this.id = id;
	}
	
	@JsonProperty("firstName")
	public String getFirstName() {
		return mFirstName;
	}

	@JsonProperty("firstName")
	public void setFirstName(String mName) {
		this.mFirstName = mName;
	}
	
	@JsonProperty("lastName")
	public String getLastName() {
		return mLastName;
	}

	@JsonProperty("lastName")
	public void setLastName(String mLastName) {
		this.mLastName = mLastName;
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
	
	@JsonProperty("gender")
	public Gender getGender() {
		return mGender;
	}

	@JsonProperty("gender")
	public void setGender(Gender mGender) {
		this.mGender = mGender;
	}

	@JsonProperty("department")
	public Department getDepartment() {
		return mDepartment;
	}

	@JsonProperty("department")
	public void setDepartment(Department mDepartment) {
		this.mDepartment = mDepartment;
	}
}
