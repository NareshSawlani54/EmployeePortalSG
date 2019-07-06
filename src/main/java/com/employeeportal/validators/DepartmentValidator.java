package com.employeeportal.validators;

import com.employeeportal.entity.Department;

public class DepartmentValidator {
	
	public static boolean validate(Department department) {
		if(department == null
				|| department.getId() <= 0 || department.getId() > 4
				|| department.getName() == null
				|| department.getName().isEmpty())
			return false;
		
		return true;
	}

}
