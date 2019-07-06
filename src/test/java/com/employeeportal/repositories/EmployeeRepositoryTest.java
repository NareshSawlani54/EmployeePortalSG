package com.employeeportal.repositories;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRepositoryTest {
	
	@Mock
	EntityManager entityManager;
	
	@Test(expected = Exception.class)
	public void givenEntityManagerNull_whenConstructor_thenThrowException() {
		new EmployeeRepository(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void givenEtityNull_whenSave_thenThrowException() {
		EmployeeRepository employeeRepository = new EmployeeRepository(entityManager);
		employeeRepository.save(null);
	}
}
