package com.jdbc.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.DTO.Employee;
import com.jdbc.factoryrepo.EmployeeServiceFactory;
import com.jdbc.service.IEmployeeService;

public class EmployeeControllerImpl implements IEmployeeControlller{

	@Override
	public int insertEmployee(Employee employee) throws SQLException {
		IEmployeeService ies=EmployeeServiceFactory.getEmployeeService();
		return ies.insertEmployee(employee);
	}

	@Override
	public ResultSet getEmployee(Employee employee) throws SQLException, IOException {
		IEmployeeService ies=EmployeeServiceFactory.getEmployeeService();
		return ies.getEmployee(employee);
	}

}
