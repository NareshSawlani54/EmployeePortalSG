package com.employeeportal.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.employeeportal.entity.Department;

public class DepartmentValidatorTest {
	
	@Test
	public void givenWrongID_whenValidate_thenReturnFalse() {
		assertFalse(DepartmentValidator.validate(new Department(0,"Test")));
	}

	
	@Test
	public void givenCorrectID_whenValidate_thenReturnTrue() {
		assertTrue(DepartmentValidator.validate(new Department(2,"Test")));
	}
	
	@Test
	public void givenDepartmentNull_whenValidate_thenReturnFalse() {
		assertFalse(DepartmentValidator.validate(null));
	}
}
