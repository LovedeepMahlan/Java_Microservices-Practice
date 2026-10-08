package in.pwskills.nitin.service;


import java.util.List;

import in.pwskills.nitin.beans.Employee;

public interface IEmployeeService {

	//save the Employee
	public void saveRecord(Employee employee);
	
	//get employee list
	public List<Employee> displayAllRecord();
	
	//delete record
	public void deleteRecord(Integer id);
	
	//get employee
	public Employee findEmployee(Integer id);
	
}