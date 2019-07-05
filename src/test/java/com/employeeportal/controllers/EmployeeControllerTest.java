package com.employeeportal.controllers;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.employeeportal.entity.Department;
import com.employeeportal.entity.Employee;
import com.employeeportal.entity.Employee.Gender;
import com.employeeportal.services.EmployeeService;
import com.employeeportal.validators.EmployeeValidator;

@RunWith(PowerMockRunner.class)
public class EmployeeControllerTest {
	
	@Mock
	Employee employeeTestObject;
	
	@Mock
	EmployeeService employeeService;
	
	@Test(expected = RuntimeException.class)
	public void givenEmployeeNull_whenSave_thenThrowException() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		employeeController.saveEmployee(null);
	}
	
	@Test
	@PrepareForTest(EmployeeValidator.class)
	public void givenEmployeeNotNull_whenSave_thenEmployeeValidatorIsCalled() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		PowerMockito.mockStatic(EmployeeValidator.class);
		employeeController.saveEmployee(employeeTestObject);
		PowerMockito.verifyStatic(Mockito.times(1));
	}
	
	@Test
	public void givenEmployeeValidationFails_whenSave_thenReturnsErrorString() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		Employee employee = new Employee(null,null,null,null,null);
		assertEquals(employeeController.saveEmployee(employee), "Employee Validation Failed");
	}
	
	@Test
	public void givenEmployeeValidationSucceeds_whenSave_thenReturnsSuccessString() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		Employee employee = new Employee("Test","Test",Gender.MALE,new Date(System.currentTimeMillis()),new Department());
		assertEquals(employeeController.saveEmployee(employee), "Employee Added");
	}
	
	@Test
	public void givenEmployeeValidationSucceeds_whenSave_thenEmployeeServiceIsCalled() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		Employee employee = new Employee("Test","Test",Gender.FEMALE,new Date(System.currentTimeMillis()),new Department());
		employeeController.saveEmployee(employee);
		Mockito.verify(employeeService, Mockito.times(1));
	}
	
}
