package com.employeeportal.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeportal.entity.Department;

@Repository
public class DepartmentRepository extends SimpleJpaRepository<Department, Long>{

	@Autowired
	public DepartmentRepository(EntityManager em) {
		super(Department.class, em);
	}
	
	@Override
	public List<Department> findAll() {
		return super.findAll();
	}

}
