package com.jdbc.service;
import java.sql.SQLException;

import com.jdbc.DTO.Student;

public interface IStudentService {
	public int insertRecord(Student student) throws SQLException;
}
