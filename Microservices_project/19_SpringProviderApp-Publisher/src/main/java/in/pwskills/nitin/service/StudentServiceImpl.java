package in.pwskills.nitin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.entity.Student;
import in.pwskills.nitin.repository.IStudentRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements IStudentService{

	@Autowired
	IStudentRepo repo;

	@Override
	public Mono<Student> insertStudent(Student stud) {
		return repo.insert(stud);
	}

	@Override
	public Mono<Student> getStudent(String id) {
		return repo.findById(id).switchIfEmpty(Mono.empty());
	}

	@Override
	public Mono<Void> deleteStudent(String id) {
		// TODO Auto-generated method stub
		return repo.deleteById(id);
	}

	@Override
	public Flux<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
}
