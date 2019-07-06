package com.employeeportal.repositories;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeportal.entity.Employee;
@Repository
public class EmployeeRepository extends SimpleJpaRepository<Employee, Long>{

	public EmployeeRepository(EntityManager em) {
		super(Employee.class, em);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public <S extends Employee> S save(S entity) {
		if(entity == null)
			throw new IllegalArgumentException();
		return super.save(entity);
	}
	
}