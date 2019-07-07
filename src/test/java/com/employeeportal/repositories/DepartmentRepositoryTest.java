package com.employeeportal.repositories;

import org.junit.Test;

public class DepartmentRepositoryTest {
	
	@Test(expected = Exception.class)
	public void givenEntityManagerNull_whenConstructor_thenThrowException() {
		new DepartmentRepository(null);
	}

}
