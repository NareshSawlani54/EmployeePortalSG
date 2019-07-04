package com.employeeportal.controllers;

import org.junit.Test;

public class EmployeeControllerTest {
	
	@Test(expected = Exception.class)
	public void givenEmployeeNull_whenSave_thenThrowException() throws Exception {
		EmployeeController employeeController = new EmployeeController();
		employeeController.saveEmployee(null);
	}
	
}
