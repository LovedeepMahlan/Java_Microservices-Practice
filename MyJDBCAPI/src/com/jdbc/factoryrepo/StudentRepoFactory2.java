package com.jdbc.factoryrepo;

import com.jdbc.repository.IStudentRepo2;
import com.jdbc.repository.StudentRepo2Impl;

public class StudentRepoFactory2 {
    private static IStudentRepo2 studentRepo = null;

    public static IStudentRepo2 getStudentRepo() {
        if (studentRepo == null) {
            // Initialize studentRepo here
            // For example:
            studentRepo = new StudentRepo2Impl(); // Assuming StudentRepoImpl2 implements IStudentRepo2
        }
        return studentRepo;
    }
}