package com.jdbc.controller;

import java.sql.SQLException;

import com.jdbc.DTO.Student;

public interface IStudentController {
public int insertRecord(Student s) throws SQLException;
}
