package in.pwskills.nitin.service;


import org.springframework.data.domain.Pageable;

import in.pwskills.nitin.beans.Employee;

public interface IEmployeeService {

	//save the Employee
	public void saveRecord(Employee employee);
	
	//get employee list
	public org.springframework.data.domain.Page<Employee> displayAllRecord(Pageable pageable);
	
	//delete record
	public void deleteRecord(Integer id);
	
	//get employee
	public Employee findEmployee(Integer id);
	
}