package in.compney.factory;

import in.compney.Repository.StudenrRepositoryIclass;
import in.compney.Repository.StudentRepository;

public class StudentRepofactory {
	static StudentRepository studentrepos=null;
	public static StudentRepository getStudeRepo() {
		if (studentrepos==null) {
			studentrepos=new StudenrRepositoryIclass();
		}
		return studentrepos;
	}
}

