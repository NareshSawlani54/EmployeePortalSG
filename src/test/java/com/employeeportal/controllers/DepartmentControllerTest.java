package com.employeeportal.controllers;

import org.junit.Test;

public class DepartmentControllerTest {
	@Test(expected = NullPointerException.class)
	public void givenDepartmentServiceNull_whenGetAll_thenThrowsException() {
		DepartmentController departmentController = new DepartmentController(null);
		departmentController.getAllDepartments();
	}
}
