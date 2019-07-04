package com.employeeportal.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeportal.entity.Employee;
import com.employeeportal.validators.EmployeeValidator;


public class EmployeeController {
	
	public String saveEmployee(Employee employeeObject) {
		if(employeeObject == null)
			throw new RuntimeException("Employee Cannot be Null");
		EmployeeValidator.validateEmployee(employeeObject);
		return "";
	}
	
}
