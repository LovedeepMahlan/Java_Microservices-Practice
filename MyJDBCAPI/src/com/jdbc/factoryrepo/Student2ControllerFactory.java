package com.jdbc.factoryrepo;

import com.jdbc.controller.IStudent2Controller;
import com.jdbc.controller.Student2Controller;

public class Student2ControllerFactory {
private static IStudent2Controller ISC2;
public static IStudent2Controller getStudet2Controller() {
	if(ISC2==null) {
		ISC2=new Student2Controller();
	}
	return ISC2;
}
}
