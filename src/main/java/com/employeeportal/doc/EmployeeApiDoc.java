package com.employeeportal.doc;

public interface EmployeeApiDoc {
	String CONTROLLER_PATH = "/employee";
	String CORS_PATH = "http://localhost:4200";
	String TAG = "Employee RestFul Services";
	String CONSUMES_JSON = "application/json";
    String PRODUCES_JSON = "application/json";
    String OPERATION_FAILED = "Operation Failed";
	
	public interface SaveEmployee {
		String SAVE_PATH = "/save";
		String DETAIL = "Adds An Employee to Database";
		String NOTES = "Pass An Employee and Rest Api will Save it to Database";
		String PARAM_DETAILS = "Employee Details";
		String PARAM_DATATYPE = "Employee";
		int RESPONSE_201 = 201;
		String RESPONSE_201_MSG = "Employee Added Successfully";
		int RESPONSE_400 = 400;
		String RESPONSE_400_MSG = "Employee Validation Failed";
		int RESPONSE_403 = 403;
		String RESPONSE_403_MSG = "Employee Addition Failed";
		String EMPLOYEE_CANNOT_NULL = "Employee Cannot be Null";
	}
	
	public interface GetAllEmployees {
		String GET_PATH = "/getAll";
		String DETAIL = "Retrives All Employees From Database";
		String NOTES = "Rest Api will Return All Existing Records of Employees Sorted By First Name";
	}
	
	public interface EmployeeDoc {
		String Model_Desc = "All Details About An Empoyee";
		
		String ID = "id";
		
		int FirstName_Pos = 1;
		String FirstName = "firstName";
		String FirstName_Detail = "First Name Of Empoyee";
		String FirstName_Example = "Naresh";
		String FirstName_Column_Name = "first_name";
		
		int LastName_Pos = 2;
		String LastName = "lastName";
		String LastName_Detail = "Last Name Of Empoyee";
		String LastName_Example = "Sawlani";
		String LastName_Column_Name = "last_name";
		

		int Gender_Pos = 3;
		String Gender = "gender";
		String Gender_Detail = "Gender Name Of Empoyee";
		String Gender_Example = "MALE";
		String Gender_Column_Name = "gender";
		
		int DOB_Pos = 4;
		String DOB = "dob";
		String DOB_Pattern = "yyyy-MM-dd";
		String DOB_Notes = "Must be in YYYY-MM-DD Format";
		String DOB_Detail = "DOB Of Empoyee";
		String DOB_Example = "1989-06-23";
		String DOB_Column_Name = "dob";
		
		int Department_Pos = 5;
        String DepartmentFKColumnName = "dept_id";
	}	

}
