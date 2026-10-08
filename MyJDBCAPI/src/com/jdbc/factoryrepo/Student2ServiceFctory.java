package com.jdbc.factoryrepo;

import com.jdbc.service.IStudentService2;
import com.jdbc.service.StudentService2Impl;

public class Student2ServiceFctory {
    private static IStudentService2 ISS2 = null;

public static IStudentService2 getStudentRepo() {
    if (ISS2 == null) {
        ISS2 = new StudentService2Impl();
    }
    return ISS2;
    }
}
