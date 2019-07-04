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
	@PrepareForTest(EmployeeValidator.class)
	public void givenEmployeeValidationFails_whenSave_thenReturnsErrorString() {
		EmployeeController employeeController = new EmployeeController();
		PowerMockito.mockStatic(EmployeeValidator.class);
		assertEquals(employeeController.saveEmployee(employeeTestObject), "Employee Validation Failed");
		PowerMockito.verifyStatic(Mockito.times(1));
	}
	
}
