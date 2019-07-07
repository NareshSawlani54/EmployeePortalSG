package com.employeeportal.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
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
	private Employee employeeTestObject;
	
	@Mock
	private EmployeeService employeeService;
	
	@Mock
	private HttpServletResponse response;
	
	@Test(expected = RuntimeException.class)
	public void givenEmployeeNull_whenSave_thenThrowException() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		employeeController.saveEmployee(null,response);
	}
	
	@Test
	@PrepareForTest(EmployeeValidator.class)
	public void givenEmployeeNotNull_whenSave_thenEmployeeValidatorIsCalled() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		PowerMockito.mockStatic(EmployeeValidator.class);
		employeeController.saveEmployee(employeeTestObject,response);
		PowerMockito.verifyStatic(Mockito.times(1));
	}
	
	@Test
	public void givenEmployeeValidationFails_whenSave_thenReturnsErrorString() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		Employee employee = new Employee(null,null,null,null,null);
		assertEquals(employeeController.saveEmployee(employee,response), "Employee Validation Failed");
	}
	
	@Test
	public void givenEmployeeValidationSucceeds_whenSave_thenReturnsSuccessString() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		Employee employee = new Employee("Test","Test",Gender.MALE,new Date(System.currentTimeMillis()),new Department(1,"Test"));
		Mockito.when(employeeService.saveEmployee(employee)).thenReturn(true);
		assertEquals(employeeController.saveEmployee(employee,response), "Employee Added Successfully");
	}
	
	@Test
	public void givenEmployeeValidationSucceeds_whenSave_thenEmployeeServiceIsCalled() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		Employee employee = new Employee("Test","Test",Gender.FEMALE,new Date(System.currentTimeMillis()),new Department());
		employeeController.saveEmployee(employee,response);
		Mockito.verify(employeeService, Mockito.times(1));
	}
	
	@Test
	public void givenEmployeeServiceReturnTrue_whenSave_thenReturnSuccessString() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		Employee employee = new Employee("Test","Test",Gender.FEMALE,new Date(System.currentTimeMillis()),new Department(1,"Test"));
		Mockito.when(employeeService.saveEmployee(employee)).thenReturn(true);
		assertEquals(employeeController.saveEmployee(employee,response),"Employee Added Successfully");
	}
	
	@Test
	public void givenEmployeeServiceReturnFalse_whenSave_thenReturnFailureString() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		Employee employee = new Employee("Test","Test",Gender.FEMALE,new Date(System.currentTimeMillis()),new Department(1,"Test"));
		Mockito.when(employeeService.saveEmployee(employee)).thenReturn(false);
		assertEquals(employeeController.saveEmployee(employee,response),"Employee Addition Failed");
	}
	
	@Test(expected = NullPointerException.class)
	public void givenEmployeeServiceNull_whenGetAll_thenThrowsException() {
		EmployeeController employeeController = new EmployeeController(null);
		employeeController.getAllEmployees();
	}
	
	@Test
	public void givenEmployeeServiceNull_whenSaveEmpoyee_thenReturnErrorSring() {
		EmployeeController employeeController = new EmployeeController(null);
		Employee employee = new Employee("Test","Test",Gender.FEMALE,new Date(System.currentTimeMillis()),new Department(1,"Test"));
		assertEquals(employeeController.saveEmployee(employee,response),"Employee Addition Failed");
	}
	
	@Test
	public void givenUnknownExceptionOccured_whenSaveEmpoyee_thenReturnErrorSring() {
		EmployeeController employeeController = new EmployeeController(employeeService);
		assertEquals(employeeController.handleAllUnknownExceptions(Mockito.mock(Exception.class), response),"Operation Failed");
	}
}
