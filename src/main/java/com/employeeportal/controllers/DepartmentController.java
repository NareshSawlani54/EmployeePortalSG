package com.employeeportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeportal.entity.Department;
import com.employeeportal.services.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "Department RestFul Services" })
@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private DepartmentService mDepartmentService;
	
	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.mDepartmentService = departmentService;
	}
	
	@GetMapping("/getAll")
	@ApiOperation(consumes = "application/json",produces = "application/json", value = "Retrives All Departments From Database",
	  notes = "Rest Api will Return All Existing Records of Departments")
	public List<Department> getAllDepartments() {
		return mDepartmentService.getAllDepartments();
	}
	
}
