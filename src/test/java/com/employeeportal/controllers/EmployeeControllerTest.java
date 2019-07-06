package com.employeeportal.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
		Employee employee = new Employee(0,null,null,null,null,null);
		assertEquals(employeeController.saveEmployee(employee), "Employee Validation Failed");
	}
	
	@Test
	public void givenEmployeeValidationSucceeds_whenSave_thenReturnsSuccessString() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		Employee employee = new Employee(1,"Test","Test",Gender.MALE,new Date(System.currentTimeMillis()),new Department(1,"Test"));
		Mockito.when(employeeService.saveEmployee(employee)).thenReturn(true);
		assertEquals(employeeController.saveEmployee(employee), "Employee Added Successfully");
	}
	
	@Test
	public void givenEmployeeValidationSucceeds_whenSave_thenEmployeeServiceIsCalled() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		Employee employee = new Employee(1,"Test","Test",Gender.FEMALE,new Date(System.currentTimeMillis()),new Department());
		employeeController.saveEmployee(employee);
		Mockito.verify(employeeService, Mockito.times(1));
	}
	
	@Test
	public void givenEmployeeServiceReturnTrue_whenSave_thenReturnSuccessString() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		Employee employee = new Employee(1,"Test","Test",Gender.FEMALE,new Date(System.currentTimeMillis()),new Department(1,"Test"));
		Mockito.when(employeeService.saveEmployee(employee)).thenReturn(true);
		assertEquals(employeeController.saveEmployee(employee),"Employee Added Successfully");
	}
	
	@Test
	public void givenEmployeeServiceReturnFalse_whenSave_thenReturnFailureString() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		Employee employee = new Employee(1,"Test","Test",Gender.FEMALE,new Date(System.currentTimeMillis()),new Department(1,"Test"));
		Mockito.when(employeeService.saveEmployee(employee)).thenReturn(false);
		assertEquals(employeeController.saveEmployee(employee),"Employee Addition Failed");
	}
	
	
	
}
