package com.employeeportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeportal.entity.Employee;
import com.employeeportal.services.EmployeeService;
import com.employeeportal.validators.EmployeeValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Api(tags = { "Employee RestFul Services" })
@RestController
@RequestMapping("/employee")
@EnableSwagger2
public class EmployeeController {
	
	private EmployeeService mEmployeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.mEmployeeService = employeeService;
	}
	
	@PostMapping("/save")
	@ApiOperation(consumes = "application/json",produces = "application/json", value = "Add An Employee to Database",
				  notes = "Pass An Employee and Rest Api will Save it to Database")
	//@ApiImplicitParam(name = "employeeObject",dataTypeClass = Employee.class ,required = true, paramType = "body")
	public String saveEmployee(@RequestBody
			@ApiParam(name = "employee" , required = true, value = "Employee Details",type = "com.employeeportal.entity.Employee")
			Employee employeeObject) {
		if(employeeObject == null)
			throw new RuntimeException("Employee Cannot be Null");
		if(!EmployeeValidator.validateEmployee(employeeObject))
			return "Employee Validation Failed";
		
		if(mEmployeeService == null || !mEmployeeService.saveEmployee(employeeObject))
			return "Employee Addition Failed";
		
		return "Employee Added Successfully";
	}
	
	@GetMapping("/getAll")
	@ApiOperation(consumes = "application/json",produces = "application/json", value = "Retrives All Employees From Database",
	  notes = "Rest Api will Return All Existing Records of Employees")
	public List<Employee> getAllEmployees() {
		return mEmployeeService.getAllEmpoyeesSortedAscending();
	}
	
}
