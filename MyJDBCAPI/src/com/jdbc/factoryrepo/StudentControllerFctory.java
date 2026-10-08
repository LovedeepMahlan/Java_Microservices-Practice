package com.jdbc.factoryrepo;

import com.jdbc.controller.IStudentController;
import com.jdbc.controller.StudentControllerImpl;

public class StudentControllerFctory {
	public static IStudentController controller=null;
	public static IStudentController getStudentController() {
		if(controller==null)
			controller=new StudentControllerImpl();
		return controller;
	}
}
