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

import com.employeeportal.doc.DepartmentApiDoc.DepartmentDoc;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.employeeportal.doc.EmployeeApiDoc.EmployeeDoc.*;

@ApiModel(description = Model_Desc)
@Entity
public class Employee {
	
	public enum Gender {
		MALE,FEMALE;
	}
	
	@JsonProperty("id")
	@ApiModelProperty(required = false,hidden = true,position = 0)
	@Id
	@GeneratedValue
	@Column(name = ID)
	private long id;
	
	@JsonProperty(FirstName)
	@ApiModelProperty(value = FirstName_Detail,example = FirstName_Example,position = FirstName_Pos)
	@Column(name = FirstName_Column_Name)
	private String mFirstName;
	
	@JsonProperty(LastName)
	@ApiModelProperty(value = LastName_Detail,example = LastName_Example,position = LastName_Pos)
	@Column(name = LastName_Column_Name)
	private String mLastName;
	
	@JsonProperty(Gender)
	@ApiModelProperty(value = Gender_Detail, example = Gender_Example,position = Gender_Pos)
	@Column(name = Gender_Column_Name)
	@Enumerated(EnumType.STRING)
	private Gender mGender;
	
	@JsonProperty(DOB)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DOB_Pattern)
	@ApiModelProperty(value = DOB_Detail, notes = DOB_Notes, example = DOB_Example,position = DOB_Pos)
	@Column(name = DOB_Column_Name)
	private Date mDOB;
	
	@JsonProperty(DepartmentDoc.Department)
	@ApiModelProperty(position = Department_Pos)
	@ManyToOne
	@JoinColumn(name = DepartmentFKColumnName, nullable = true)
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
