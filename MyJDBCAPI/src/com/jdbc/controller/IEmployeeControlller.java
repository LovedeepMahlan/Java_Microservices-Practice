package com.jdbc.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.DTO.Employee;

public interface IEmployeeControlller {
	public int insertEmployee(Employee employee) throws SQLException;
	public ResultSet getEmployee(Employee employee)throws SQLException, IOException;
}
