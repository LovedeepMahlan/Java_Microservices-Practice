package com.jdbc.service;

import java.sql.SQLException;

import com.jdbc.DTO.Student;
import com.jdbc.factoryrepo.StudentRepoFactory;
import com.jdbc.repository.IStudentRepo;

public class IStudentServiceImpl implements IStudentService{
@Override
public int insertRecord(Student stud) throws SQLException {
	IStudentRepo repo=StudentRepoFactory.getStudentRepo();
	return repo.insertRecord(stud);
}
}
