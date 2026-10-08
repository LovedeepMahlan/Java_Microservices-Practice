package com.jdbc.factoryrepo;

import com.jdbc.repository.EmployeeRepoImpl;
import com.jdbc.repository.IEmployeeRepo;

public class EmployeeRepoFactory {
public static IEmployeeRepo ier=null;
public static IEmployeeRepo employeeRepo() {
	if(ier==null) {
		ier=new EmployeeRepoImpl();
	}
	return ier;
}
}
