package com.employeeportal.services;

import org.springframework.stereotype.Service;

import com.employeeportal.entity.Employee;
import com.employeeportal.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository mEmployeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.mEmployeeRepository = employeeRepository;
	}

	public boolean saveEmployee(Employee employee) {
		mEmployeeRepository.save(employee);
		return false;
	}
	
}
