package com.employeeportal.repositories;

import org.junit.Test;

public class EmployeeRepositoryTest {
	
	@Test(expected = Exception.class)
	public void givenEntityManagerNull_whenConstructor_thenThrowException() {
		EmployeeRepository employeeRepository = new EmployeeRepository(null);
	}

}
