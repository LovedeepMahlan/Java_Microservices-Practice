package com.jdbc.controller;

import java.sql.SQLException;

import com.jdbc.DTO.Student;
import com.jdbc.factoryrepo.StudentServiceFactory;
import com.jdbc.service.IStudentService;

public class StudentControllerImpl implements IStudentController{

	@Override
	public int insertRecord(Student s) throws SQLException {
		IStudentService Service=StudentServiceFactory.getStudentService();
		return Service.insertRecord(s);
		
	}

}
