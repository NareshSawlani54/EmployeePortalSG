package com.employeeportal.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Department {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String mDepartmentName;
	
	public Department() {}

	public Department(long id, String departmentName) {
		this.id = id;
		this.mDepartmentName = departmentName;
	}

	@JsonProperty("id")
	public long getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return mDepartmentName;
	}

	@JsonProperty("name")
	public void setName(String departmentName) {
		this.mDepartmentName = departmentName;
	}
	
}
