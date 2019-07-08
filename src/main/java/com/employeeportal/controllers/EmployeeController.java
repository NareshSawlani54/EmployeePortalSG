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


import static com.employeeportal.doc.EmployeeApiDoc.*;
import static com.employeeportal.doc.EmployeeApiDoc.SaveEmployee.*;
import static com.employeeportal.doc.EmployeeApiDoc.GetAllEmployees;

@Api(tags = { TAG })
@RestController
@RequestMapping(CONTROLLER_PATH)
public class EmployeeController {
	
	private EmployeeService mEmployeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.mEmployeeService = employeeService;
	}
	
	@CrossOrigin(origins = CORS_PATH )
	@PostMapping(path = SAVE_PATH,produces = {PRODUCES_JSON},consumes = {CONSUMES_JSON})
	@ApiOperation(consumes = CONSUMES_JSON,produces = PRODUCES_JSON, value = DETAIL,
				  notes = NOTES)
	@ApiImplicitParams (
		value = { 
			@ApiImplicitParam(paramType = "body",name = "employeeObject",dataTypeClass = Employee.class ,required = true,value = PARAM_DETAILS,dataType = PARAM_DATATYPE) 
		}
	)
	@ApiResponses(
			value = {
					@ApiResponse(code = RESPONSE_201, message = RESPONSE_201_MSG),
					@ApiResponse(code = RESPONSE_400, message = RESPONSE_400_MSG),
					@ApiResponse(code = RESPONSE_403, message = RESPONSE_403_MSG)
			}
			)
	public String saveEmployee(@RequestBody Employee employeeObject, HttpServletResponse response) {
		if(employeeObject == null)
			throw new RuntimeException(EMPLOYEE_CANNOT_NULL);
		if(!EmployeeValidator.validateEmployee(employeeObject)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return RESPONSE_400_MSG;
		}
		
		if(mEmployeeService == null || !mEmployeeService.saveEmployee(employeeObject)) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return RESPONSE_403_MSG;
		}
		
		response.setStatus(HttpServletResponse.SC_CREATED);
		return RESPONSE_201_MSG;
	}
	
	@CrossOrigin(origins = CORS_PATH)
	@GetMapping(path = GetAllEmployees.GET_PATH,produces = {PRODUCES_JSON})
	@ApiOperation(consumes = CONSUMES_JSON,produces = PRODUCES_JSON, value = GetAllEmployees.DETAIL,
	  notes = GetAllEmployees.NOTES)
	public List<Employee> getAllEmployees() {
		return mEmployeeService.getAllEmpoyeesSortedAscending();
	}
	
	@ExceptionHandler(Exception.class)
	public String handleAllUnknownExceptions(Exception e, HttpServletResponse response) {
		e.printStackTrace();
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		return OPERATION_FAILED;
	}
	
}
