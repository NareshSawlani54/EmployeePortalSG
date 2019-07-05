package com.employeeportal.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.employeeportal.entity.Department;
import com.employeeportal.entity.Employee;
import com.employeeportal.entity.Employee.Gender;

public class EmployeeValidatorTest {
	
	@Test
	public void givenEmployeeFirstName_whenValidate_thenReturnsFalse() {
		Employee employeeToTest = new Employee("test", null,null, null,null);
		assertFalse(EmployeeValidator.validateEmployee(employeeToTest));
	}
	
	@Test
	public void givenEmployeeFirstLastName_whenValidate_thenReturnsFalse() {
		Employee employeeToTest = new Employee("test", "test", null, null,null);
		assertFalse(EmployeeValidator.validateEmployee(employeeToTest));
	}

	@Test
	public void notGivengivenEmployeeDateDepartment_whenValidate_thenReturnsFalse() {
		Employee employeeToTest = new Employee("test", "test", Gender.MALE, null, null);
		assertFalse(EmployeeValidator.validateEmployee(employeeToTest));
	}
	
	@Test
	public void notGivenEmployeeDepartment_whenValidate_thenReturnsFalse() {
		Employee employeeToTest = new Employee("test", "test", Gender.MALE, new Date(System.currentTimeMillis()), null);
		assertFalse(EmployeeValidator.validateEmployee(employeeToTest));
	}
	
	@Test
	public void givenEmployeeAllFields_whenValidate_thenReturnsTrue() {
		Employee employeeToTest = new Employee("test", "test", Gender.MALE, new Date(System.currentTimeMillis()), new Department());
		assertTrue(EmployeeValidator.validateEmployee(employeeToTest));
	}
}
