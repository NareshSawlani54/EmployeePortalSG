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


import static com.employeeportal.doc.DepartmentApiDoc.DepartmentDoc.*;

@Entity
@ApiModel(description = Model_Desc)
public class Department {
	
	@Id
	@GeneratedValue
	@Column(name = ID)
	@JsonProperty(ID)
	@ApiModelProperty(example = IDExample,value = ID_Detail, required = true, notes = ID_Notes,allowableValues = ID_Range)
	private long id;
	
	@JsonProperty(Name)
	@Column(name = Name_ColumnName)
	@ApiModelProperty(value = Name_Detail, example = Name_Exmaple)
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
