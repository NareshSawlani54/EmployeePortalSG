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
	@JsonProperty("id")
	@ApiModelProperty(example = "1",value = "Id of Department", required = true, notes = "Must be Ranging from 1 to 4",allowableValues = "range[1,4]")
	private long id;
	
	@JsonProperty("name")
	@Column(name = "name")
	@ApiModelProperty(value = "Name of Department", example = "IT")
	private String mDepartmentName;
	
	public Department() {}

	public Department(long id, String departmentName) {
		this.id = id;
		this.mDepartmentName = departmentName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return mDepartmentName;
	}

	public void setName(String departmentName) {
		this.mDepartmentName = departmentName;
	}
	
}
