package com.employeeportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeportal.entity.Department;
import com.employeeportal.repositories.DepartmentRepository;

@Service
public class DepartmentService {
	
	DepartmentRepository mDepartmentRepository;

	@Autowired
	public DepartmentService(DepartmentRepository departmentRepository) {
		this.mDepartmentRepository = departmentRepository;
	}

	public List<Department> getAllDepartments() {
		return mDepartmentRepository.findAll();
	}

}
