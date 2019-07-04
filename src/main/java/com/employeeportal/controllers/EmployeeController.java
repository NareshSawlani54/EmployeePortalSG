package com.employeeportal.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeportal.entity.Employee;


public class EmployeeController {
	
	public String saveEmployee(Employee employeeObject) throws Exception {
		if(employeeObject == null)
			throw new Exception();
		return "";
	}
	
}
