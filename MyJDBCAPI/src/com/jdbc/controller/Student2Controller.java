package com.jdbc.controller;

import java.sql.SQLException;

import com.jdbc.DTO.Student2;
import com.jdbc.factoryrepo.Student2ServiceFctory;
import com.jdbc.service.IStudentService2;

public class Student2Controller implements IStudent2Controller{

	@Override
	public int deleterecord(Student2 stud) throws SQLException {
		IStudentService2 ISS2=Student2ServiceFctory.getStudentRepo();
		return ISS2.deleterecord(stud);
	}


}
