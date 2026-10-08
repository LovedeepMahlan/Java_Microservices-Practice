package com.jdbc.service;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.DTO.Employee;
import com.jdbc.factoryrepo.EmployeeRepoFactory;
import com.jdbc.repository.IEmployeeRepo;

public class EmployeeServiceImpl implements IEmployeeService{
	public int insertEmployee(Employee employee) throws SQLException{
		IEmployeeRepo eri=EmployeeRepoFactory.employeeRepo();
		return eri.insertEmployee(employee);
	}
	public ResultSet getEmployee(Employee employee)throws SQLException, IOException{
		IEmployeeRepo eri=EmployeeRepoFactory.employeeRepo();
		return eri.getEmployee(employee);
	}

	
}
