package com.jdbc.factoryrepo;

import com.jdbc.service.EmployeeServiceImpl;
import com.jdbc.service.IEmployeeService;
import com.jdbc.service.IStudentService;
import com.jdbc.service.IStudentServiceImpl;

public class EmployeeServiceFactory {
public static IEmployeeService ies=null;
public static IEmployeeService getEmployeeService() {
	if(ies==null) {
		ies=new EmployeeServiceImpl();
	}
	return ies;
}
}
