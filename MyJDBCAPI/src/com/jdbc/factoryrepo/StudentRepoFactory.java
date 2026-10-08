package com.jdbc.factoryrepo;

import com.jdbc.repository.IStudentRepo;
import com.jdbc.repository.IStudentRepoImpl;

public class StudentRepoFactory {
    private static IStudentRepo StudentRepo=null;
    public static IStudentRepo getStudentRepo() {
    	if(StudentRepo==null) {
    		StudentRepo=new IStudentRepoImpl();
    	}
    	return StudentRepo;
    }
}
