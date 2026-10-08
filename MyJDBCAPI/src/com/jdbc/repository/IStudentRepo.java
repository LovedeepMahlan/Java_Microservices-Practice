package com.jdbc.repository;
import java.sql.SQLException;

import com.jdbc.DTO.Student;
public interface IStudentRepo {
	public int insertRecord(Student student) throws SQLException;
}
