package com.employeeportal.services;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.employeeportal.entity.Employee;
import com.employeeportal.repositories.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	
	@Mock
	EmployeeRepository employeeRepository;

	@Test
	public void givenEmployeePersisted_whenSaveEmployee_thenReturnTrue() {
		Employee employee = new Employee();
		Mockito.doReturn(employee).when(employeeRepository).save(employee);
		EmployeeService employeeService = new EmployeeService(employeeRepository);
		assertTrue(employeeService.saveEmployee(employee));
	}
	
}
