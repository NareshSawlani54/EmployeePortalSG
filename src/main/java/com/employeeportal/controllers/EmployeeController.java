package com.employeeportal.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { "Employee RestFul Services" })
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService mEmployeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.mEmployeeService = employeeService;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/save",produces = {"application/json"},consumes = {"application/json"})
	@ApiOperation(consumes = "application/json",produces = "application/json", value = "Add An Employee to Database",
				  notes = "Pass An Employee and Rest Api will Save it to Database")
	@ApiImplicitParams (
		value = { 
			@ApiImplicitParam(paramType = "body",name = "employeeObject",dataTypeClass = Employee.class ,required = true,value = "Employee Details",dataType = "Employee") 
		}
	)
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "Employee Added Successfully"),
					@ApiResponse(code = 400, message = "Employee Validation Failed"),
					@ApiResponse(code = 403, message = "Employee Addition Failed")
			}
			)
	public String saveEmployee(@RequestBody Employee employeeObject, HttpServletResponse response) {
		if(employeeObject == null)
			throw new RuntimeException("Employee Cannot be Null");
		if(!EmployeeValidator.validateEmployee(employeeObject)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "Employee Validation Failed";
		}
		
		if(mEmployeeService == null || !mEmployeeService.saveEmployee(employeeObject)) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return "Employee Addition Failed";
		}
		
		response.setStatus(HttpServletResponse.SC_CREATED);
		return "Employee Added Successfully";
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/getAll",produces = {"application/json"})
	@ApiOperation(consumes = "application/json",produces = "application/json", value = "Retrives All Employees From Database",
	  notes = "Rest Api will Return All Existing Records of Employees Sorted By First Name")
	public List<Employee> getAllEmployees() {
		return mEmployeeService.getAllEmpoyeesSortedAscending();
	}
	
	@ExceptionHandler(Exception.class)
	public String handleAllUnknownExceptions(Exception e, HttpServletResponse response) {
		e.printStackTrace();
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return "Operation Failed";
	}
	
}
