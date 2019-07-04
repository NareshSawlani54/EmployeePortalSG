package com.employeeportal.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.employeeportal.entity.Employee;
import com.employeeportal.entity.Employee.Gender;
import com.employeeportal.validators.EmployeeValidator;

@RunWith(PowerMockRunner.class)
public class EmployeeControllerTest {
	
	@Mock
	Employee employeeTestObject;
	
	@Test(expected = RuntimeException.class)
	public void givenEmployeeNull_whenSave_thenThrowException() {
		EmployeeController employeeController = new EmployeeController();
		employeeController.saveEmployee(null);
	}
	
	@Test
	@PrepareForTest(EmployeeValidator.class)
	public void givenEmployeeNotNull_whenSave_thenEmployeeValidatorIsCalled() {
		EmployeeController employeeController = new EmployeeController();
		PowerMockito.mockStatic(EmployeeValidator.class);
		employeeController.saveEmployee(employeeTestObject);
		PowerMockito.verifyStatic(Mockito.times(1));
	}
	
	@Test
	public void givenEmployeeValidationFails_whenSave_thenReturnsErrorString() {
		EmployeeController employeeController = new EmployeeController();
		Employee employee = new Employee(null,null,null);
		assertEquals(employeeController.saveEmployee(employee), "Employee Validation Failed");
	}
	
	@Test
	public void givenEmployeeValidationSucceeds_whenSave_thenReturnsSuccessString() {
		EmployeeController employeeController = new EmployeeController();
		Employee employee = new Employee("Test","Test",Gender.MALE);
		assertEquals(employeeController.saveEmployee(employee), "Employee Added");
	}
	
}
