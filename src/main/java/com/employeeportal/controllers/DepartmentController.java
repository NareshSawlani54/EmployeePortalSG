package com.employeeportal.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeportal.entity.Department;
import com.employeeportal.services.DepartmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import static com.employeeportal.doc.DepartmentApiDoc.*;
import static com.employeeportal.doc.DepartmentApiDoc.GetAllDepartments.*;
import static com.employeeportal.doc.DepartmentApiDoc.DepartmentDoc.*;

@Api(tags = { TAG })
@RestController
@RequestMapping(CONTROLLER_PATH)
public class DepartmentController {
	
	private DepartmentService mDepartmentService;
	
	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.mDepartmentService = departmentService;
	}
	
	@CrossOrigin(origins = CORS_PATH)
	@GetMapping(path = GET_PATH,produces = {PRODUCES_JSON})
	@ApiOperation(consumes = CONSUMES_JSON,produces = PRODUCES_JSON, value = DETAIL,
	  notes = NOTES)
	public List<Department> getAllDepartments() {
		return mDepartmentService.getAllDepartments();
	}
	
}
