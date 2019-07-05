package com.employeeportal.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.employeeportal.entity.Department;
import com.employeeportal.entity.Employee;
import com.employeeportal.entity.Employee.Gender;

public class EmployeeValidatorTest {
	
	@Test
	public void givenEmployeeFirstNameOnly_whenValidate_thenReturnsFalse() {
		Employee employeeToTest = new Employee("test", null,null, null,null);
		assertFalse(EmployeeValidator.validateEmployee(employeeToTest));
	}
	
	@Test
	public void givenEmployeeFirstLastNameOnly_whenValidate_thenReturnsFalse() {
		Employee employeeToTest = new Employee("test", "test", null, null,null);
		assertFalse(EmployeeValidator.validateEmployee(employeeToTest));
	}

	@Test
	public void notGivengivenEmployeeDOBDepartment_whenValidate_thenReturnsFalse() {
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
	
	@Test
	public void givenEmployeeFirstNameEmpty_whenValidate_thenReturnsFalse() {
		Employee employeeToTest = new Employee("", "test", Gender.MALE, new Date(System.currentTimeMillis()), new Department());
		assertFalse(EmployeeValidator.validateEmployee(employeeToTest));
	}
	
	@Test
	public void givenEmployeeFirstLastNameEmpty_whenValidate_thenReturnsFalse() {
		Employee employeeToTest = new Employee("test", "", Gender.MALE, new Date(System.currentTimeMillis()), new Department());
		assertFalse(EmployeeValidator.validateEmployee(employeeToTest));
	}
	
	@Test
	public void givenEmployeeDOBForFuture_whenValidate_thenReturnsFalse() {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.DAY_OF_MONTH, today.get(Calendar.DAY_OF_MONTH) + 1);
		Date tomorrow = today.getTime();
		Employee employeeToTest = new Employee("test", "test", Gender.MALE, tomorrow, new Department());
		assertFalse(EmployeeValidator.validateEmployee(employeeToTest));
	}
}
