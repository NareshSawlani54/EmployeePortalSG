package com.employeeportal.doc;

public interface DepartmentApiDoc {

	String CONTROLLER_PATH = "/department";
	String CORS_PATH = "http://localhost:4200";
	String TAG = "Department RestFul Services" ;
	String CONSUMES_JSON = "application/json";
    String PRODUCES_JSON = "application/json";
    
	public interface GetAllDepartments {
		String GET_PATH = "/getAll";
		String DETAIL = "Retrives All Departments From Database";
		String NOTES = "Rest Api will Return All Existing Records of Departments";
	}
    
	public interface DepartmentDoc {
		String Model_Desc = "All Details About An Empoyee";
		
		String Department = "department";
		String ID = "id";
		String IDExample = "1";
		String ID_Detail = "Id of Department";
		String ID_Notes = "Must be Ranging from 1 to 4";
		String ID_Range = "range[1,4]";
		
		String Name = "name";
		String Name_ColumnName = "name";
		String Name_Detail = "Name of Department";
		String Name_Exmaple = "IT";
	}
}
