package com.jdbc.controller;

import java.sql.SQLException;

import com.jdbc.DTO.Student2;

public interface IStudent2Controller {

int deleterecord(Student2 stud) throws SQLException;
}
