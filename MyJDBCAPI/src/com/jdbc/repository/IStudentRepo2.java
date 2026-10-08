package com.jdbc.repository;

import java.sql.SQLException;

import com.jdbc.DTO.Student2;

public interface IStudentRepo2 {
public int deleterecord(Student2 student) throws SQLException;
}
