package com.employeeportal.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "All Details Of Department")
public class Department {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	@ApiModelProperty(value = "Id of Department", required = true, notes = "Must be Ranging from 1 to 4")
	private long id;
	
	@Column(name = "name")
	@ApiModelProperty(value = "NAme of Department",required = false)
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
