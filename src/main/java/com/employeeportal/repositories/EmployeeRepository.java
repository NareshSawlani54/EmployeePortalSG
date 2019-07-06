package com.employeeportal.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeportal.entity.Employee;
@Repository
public class EmployeeRepository extends SimpleJpaRepository<Employee, Long>{

	@Autowired
	public EmployeeRepository(EntityManager em) {
		super(Employee.class, em);
	}
	
	@Override
	public <S extends Employee> S save(S entity) {
		if(entity == null)
			throw new IllegalArgumentException();
		return super.save(entity);
	}
	
	@Override
	public List<Employee> findAll(Sort sort) {
		return super.findAll(sort);
	}
	
}