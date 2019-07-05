package com.employeeportal.validators;

import com.employeeportal.entity.Employee;

public class EmployeeValidator {
	public static boolean validateEmployee(Employee employee) {
		if(employee.getFirstName() == null)
			return false;
		if(employee.getLastName() == null)
			return false;
		if(employee.getGender() == null)
			return false;
		if(employee.getDOB() == null)
			return false;
		if(employee.getDepartment() == null)
			return false;
		return true;
	}
}
