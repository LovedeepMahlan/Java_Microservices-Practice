package in.pwskills.nitin.service;

import java.util.List;

import in.pwskills.nitin.bean.Student;

public interface IStudentService {

	public Student getStudent(Integer id);
	
	public List<Student> getStudentList();
	
	public void updateStudent(Student s);
	
	public void deleteRecord(Integer id);
	
	public Integer saveStudent(Student s);
}
