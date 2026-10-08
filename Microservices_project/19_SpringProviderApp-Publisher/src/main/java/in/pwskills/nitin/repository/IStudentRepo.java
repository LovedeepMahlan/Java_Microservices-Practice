package in.pwskills.nitin.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import in.pwskills.nitin.entity.Student;

@Repository
public interface IStudentRepo extends ReactiveMongoRepository<Student, String>{

}
