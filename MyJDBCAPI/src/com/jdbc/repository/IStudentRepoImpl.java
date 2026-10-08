package com.jdbc.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.DTO.Student;

import jdbconnection.MakeConnection_1;

public class IStudentRepoImpl implements IStudentRepo{
	private static Connection connection=null;
	static {
		try {
			connection=MakeConnection_1.dbConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
@Override
public int insertRecord(Student student) throws SQLException {
	Statement stmt=null;
	if(connection!=null) {
		stmt=connection.createStatement();
	}
	String insertQuary=null;
	insertQuary=String.format("insert into student values(%d ,'%s' ,'%s' ,%d)",student.getSid(),student.getSname(),student.getSaddress(),student.getSage());
	if(stmt!=null) {
		stmt.executeUpdate(insertQuary);
	}
	return 0;
    }

}
