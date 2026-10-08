package com.jdbc.factoryrepo;

import com.jdbc.service.IStudentService;
import com.jdbc.service.IStudentServiceImpl;

public class StudentServiceFactory {
	private StudentServiceFactory() {
		
	}
	private static IStudentService studentService=null;
	public static IStudentService getStudentService() {
		if(studentService==null) {
			studentService=new IStudentServiceImpl();
		}
		return studentService;
	}
}
