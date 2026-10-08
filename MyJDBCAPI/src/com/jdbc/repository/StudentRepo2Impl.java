package com.jdbc.repository;

import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.DTO.Student2;

import jdbconnection.MakeConnection2;

public class StudentRepo2Impl implements IStudentRepo2 {
	private  final String Delete_DB="delete from student where sid=?";
private static Connection connection=null;
static {
	try {
		connection=MakeConnection2.GetConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	@Override
	public int deleterecord(Student2 student) throws SQLException {
		
		PreparedStatement ps=null;
		if(connection!=null) {
			ps=connection.prepareStatement(Delete_DB);
		}
		if(ps!=null) {
			
			ps.setInt(1,student.getSid());
			ps.executeUpdate();
		}
		return 0;
	}
    

}
