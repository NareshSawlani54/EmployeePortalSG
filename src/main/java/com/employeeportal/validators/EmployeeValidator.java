package com.employeeportal.validators;

import com.employeeportal.entity.Employee;

public class EmployeeValidator {
	public static boolean validateEmployee(Employee employee) {
		if(employee == null
				|| employee.getId() == 0
				|| employee.getFirstName() == null || employee.getFirstName().isEmpty() 
				|| employee.getLastName() == null || employee.getLastName().isEmpty()
				|| employee.getGender() == null 
				|| employee.getDOB() == null || employee.getDOB().getTime() > System.currentTimeMillis()
				|| !DepartmentValidator.validate(employee.getDepartment()) )
			return false;
		
		return true;
	}
}
