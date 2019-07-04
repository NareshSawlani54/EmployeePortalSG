package com.employeeportal.entity;

public class Employee {
	
	public enum Gender {
		MALE,FEMALE;
	}
	
	private String mFirstName;
	private String mLastName;
	private Gender mGender;

	public Employee(String firstName,String lastName,Gender gender) {
		this.mFirstName = firstName;
		this.mLastName = lastName;
		this.mGender = gender;
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
