package com.jdbc.repository;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import com.jdbc.DTO.Employee;

import jdbconnection.MakeConnection_1;

public class EmployeeRepoImpl implements IEmployeeRepo {
	private static final String insert_Employee = "insert into employee(`ename`,`eaddress`,`resume`) values(?,?,?)";
	private static final String Select_Employee = "select * from employee where eid=?";
	private static Connection connection=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	static {
		try {
			connection=MakeConnection_1.dbConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public  int insertEmployee(Employee employee) throws SQLException {
		if(connection!=null) {
			ps=connection.prepareStatement(insert_Employee);
		}
		Scanner sc=new Scanner(System.in);
		if(ps!=null) {
			ps.setString(1,employee.getEname());
			ps.setString(2,employee.getEaddress());
			ps.setString(3, employee.getResume());
		}
		ps.executeUpdate();
		return 0;
	}
	@Override
	public ResultSet getEmployee(Employee employee) throws SQLException, IOException{
		if(connection!=null) {
			ps=connection.prepareStatement(Select_Employee);
		}
		if(ps!=null) {
			ps.setInt(1, employee.getEid());
			rs=ps.executeQuery();
		}
		if(rs.next()) {

			FileWriter fileWriter = new FileWriter(new File(employee.getLoction()));

			IOUtils.copy(rs.getCharacterStream(4), fileWriter);
			fileWriter.flush();
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		return null;
	}
}
