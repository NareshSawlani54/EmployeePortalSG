package com.employeeportal.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeportal.entity.Employee;
import com.employeeportal.services.EmployeeService;
import com.employeeportal.validators.EmployeeValidator;


public class EmployeeController {
	
	private EmployeeService mEmployeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.mEmployeeService = employeeService;
	}
	
	public String saveEmployee(Employee employeeObject) {
		if(employeeObject == null)
			throw new RuntimeException("Employee Cannot be Null");
		if(!EmployeeValidator.validateEmployee(employeeObject))
			return "Employee Validation Failed";
		
		if(!mEmployeeService.saveEmployee(employeeObject))
			return "Employee Addition Failed";
		
		return "Employee Added";
	}
	
}
