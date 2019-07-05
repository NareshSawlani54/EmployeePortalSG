package com.employeeportal.validators;

import com.employeeportal.entity.Employee;

public class EmployeeValidator {
	public static boolean validateEmployee(Employee employee) {
		if(employee.getId() == 0
				|| employee.getFirstName() == null || employee.getFirstName().isEmpty() 
				|| employee.getLastName() == null || employee.getLastName().isEmpty()
				|| employee.getGender() == null 
				|| employee.getDOB() == null || employee.getDOB().getTime() > System.currentTimeMillis()
				|| employee.getDepartment() == null)
			return false;
		
		return true;
	}
}
