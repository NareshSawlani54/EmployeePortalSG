package com.employeeportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.employeeportal.entity.Employee;
import com.employeeportal.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository mEmployeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.mEmployeeRepository = employeeRepository;
	}

	public boolean saveEmployee(Employee employee) {
		Employee persistedEmployee = mEmployeeRepository.save(employee);
		if(persistedEmployee != null)
			return true;
		return false;
	}
	
	public List<Employee> getAllEmpoyeesSortedAscending() {
		return mEmployeeRepository.findAll(new Sort(Sort.DEFAULT_DIRECTION,"mFirstName"));
	}
	
}
