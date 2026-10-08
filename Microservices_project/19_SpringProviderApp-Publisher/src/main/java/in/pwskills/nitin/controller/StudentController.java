package in.pwskills.nitin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.entity.Student;
import in.pwskills.nitin.service.IStudentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/api/student")
public class StudentController {

	
	@Autowired
	IStudentService service;
	
	/*
	 * CREATE DOCUMENT
	 * METHOD : POST
	 * PATH   : /create
	 * INPUT  : Student (@RequestBody)
	 * R.T    : Mono<Student>
	 */
	@PostMapping("/insert")
	public Mono<Student> insertStudent(
			@RequestBody 
			Student stud){
		return service.insertStudent(stud);
	}
	
	/*
	 * FIND DOCUMENT
	 * METHOD : GET
	 * PATH   : /fetch/{id}
	 * INPUT  : @PathVariable id
	 * R.T    : Mono<Student> or Empty
	 */
	@GetMapping("/find/{id}")
	public Mono<Student> getStudent(@PathVariable String id){
		return service.getStudent(id);
	}
	
	/*
	 * READ ALL DOCUMENT
	 * METHOD : GET
	 * PATH   : /findAll
	 * INPUT  : no input
	 * R.T    : Flux<Student>
	 */
	@GetMapping("/findAll")
	public Flux<Student> findAllStudent(){
		return service.getAllStudent();
	}
	
	/*
	 * DELETE ONE DOCUMENT
	 * METHOD : DELETE
	 * PATH   : /delete/{id}
	 * INPUT  : String(@PathVariable)
	 * R.T    : Mono<Void>
	 */
	@DeleteMapping("/delete/{id}")
	public Mono<Void> deleteStudent(@PathVariable String id){
		return service.deleteStudent(id);
	}
}
