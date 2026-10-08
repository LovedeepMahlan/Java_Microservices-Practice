package in.pwskills.nitin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.bean.Student;
import in.pwskills.nitin.dao.StudentRepository;
import in.pwskills.nitin.exception.StudentNotFoundException;

@Component
public class StudentServiceImpl implements IStudentService{

	@Autowired
	StudentRepository repo;
	
	@Override
	public Student getStudent(Integer id) {
		 return repo.findById(id).
				orElseThrow(()->
							new StudentNotFoundException("Student not found fo given id ::"+id));
	}

	@Override
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void updateStudent(Student s) {
		if((s.getStdId()==null) || !repo.existsById(s.getStdId())){
			throw new StudentNotFoundException("Student Not found exeption for given id :: "+s.getStdId());
		}
		else {
			repo.save(s);
		}
		
	}

	@Override
	public void deleteRecord(Integer id) {
		repo.delete(getStudent(id));
		
	}

	@Override
	public Integer saveStudent(Student s) {
		s=repo.save(s);
		return s.getStdId();
	}

}
