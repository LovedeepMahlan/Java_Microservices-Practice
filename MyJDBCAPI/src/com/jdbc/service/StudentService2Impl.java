package com.jdbc.service;

import java.sql.SQLException;

import com.jdbc.DTO.Student2;
import com.jdbc.factoryrepo.StudentRepoFactory2;
import com.jdbc.repository.IStudentRepo2;

public  class StudentService2Impl implements IStudentService2 {

	@Override
	public int deleterecord(Student2 student) throws SQLException {
		IStudentRepo2 ir2=StudentRepoFactory2.getStudentRepo();
		return ir2.deleterecord(student);
	}

}
