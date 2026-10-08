package in.pwskills.nitin.service;

import in.pwskills.nitin.entity.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IStudentService {

	public Mono<Student> insertStudent(Student stud);
	
	public Mono<Student> getStudent(String id);
	
	public Mono<Void> deleteStudent(String id);
	
	public Flux<Student> getAllStudent();
	
	
}
