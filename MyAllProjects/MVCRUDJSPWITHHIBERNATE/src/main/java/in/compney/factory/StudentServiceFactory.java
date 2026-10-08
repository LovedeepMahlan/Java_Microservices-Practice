package in.compney.factory;

import in.compney.service.StudentService;
import in.compney.service.StudentServiceIclass;

public class StudentServiceFactory {
	private static StudentService studentservice=null;
	public static StudentService getStudentService() {
		if(studentservice==null)
			studentservice=new StudentServiceIclass();
		return studentservice;
	}

}
