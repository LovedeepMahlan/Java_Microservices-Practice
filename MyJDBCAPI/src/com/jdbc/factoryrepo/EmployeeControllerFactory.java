package com.jdbc.factoryrepo;

import com.jdbc.controller.EmployeeControllerImpl;
import com.jdbc.controller.IEmployeeControlller;

public class EmployeeControllerFactory {
public static IEmployeeControlller iel;
public static IEmployeeControlller GetEmployeeController() {
	if(iel==null) {
		iel=new EmployeeControllerImpl();
	}
		return iel;
}
}