package com.employeeportal.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.employeeportal.repositories.DepartmentRepository;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {
	
	@Mock
	private DepartmentRepository departmentRepository;
	
	@Test
	public void givenDepatmentRepository_whenGetAll_thenReturnList() {
		DepartmentService departmentService = new DepartmentService(departmentRepository);
		assertNotNull(departmentService.getAllDepartments());
	}

}
