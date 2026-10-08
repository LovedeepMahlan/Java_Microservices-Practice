package in.pwskills.nitin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.pwskills.nitin.bean.Student;
import in.pwskills.nitin.exception.StudentNotFoundException;
import in.pwskills.nitin.handler.ErrorResponse;
import in.pwskills.nitin.service.IStudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/spring/rest")
public class StudentController {
	
	@Autowired
	IStudentService service;
	
	/*
	 * METHOD : POST
	 * PATH   : /create
	 * INPUT  : Student object (@RequestBody)
	 * R.T    : ResponseEntity<String>
	 * 
	 */
	
	@Operation(summary = "Save the student object")
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "201", description = "CREATE A RESOURCE AT PROVIDER",
							content = {
									@Content(mediaType="text/plain")
							}
							),
					@ApiResponse(
							responseCode = "400",description = "Bad Request",
							content= {
									@Content(mediaType="application/json")
							}
			)
			}
			)
	@PostMapping("/create")
	public ResponseEntity<String> addStudent(
			@RequestBody @Valid Student student){
		 
		Integer id=service.saveStudent(student);
		String status="STUDENT "+id+" CREATED";
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	/*
	 * METHOD : GET
	 * PATH   : /all
	 * INPUT  : no input
	 * R.T    : ResponseEntity<List<Student>>
	 * 
	 */
	
	@Operation(summary="get all student list")
	@ApiResponses(
			value= {
					@ApiResponse(
							responseCode = "200",description="Successfully data has been retrived",
							content= {
									@Content(mediaType="application/json",
											array=@ArraySchema(
													schema=@Schema(implementation=Student.class)
													)
									)
							}
							)
			}
			)
	@GetMapping("/getStudentList")
	public ResponseEntity<List<Student>> getStudList(){
		List<Student> list=service.getStudentList();
		return ResponseEntity.ok(list);
	}
	
	/*
	 * METHOD : GET
	 * PATH   : /find/{id}
	 * INPUT  : id ->  @PathVariable
	 * R.T    : ResponseEntity<Student>
	 * 
	 */
	
	@Operation(summary="Find Student by its id")
	@ApiResponses(
			value= {
					@ApiResponse(
							responseCode="200",description="Success",
							content= {
									@Content(mediaType="application/json",schema=@Schema(implementation = Student.class))
							}
							),
					@ApiResponse(
							responseCode="404",description="Student not for for given id",
							content= {
									@Content(mediaType="application/json",schema=@Schema(implementation = ErrorResponse.class))
							}
							)
			}
			)
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer id){
		Student s=service.getStudent(id);
		return ResponseEntity.ok(s);
		
	}

	/*
	 * METHOD : DELETE
	 * PATH   : /remove/{id}
	 * INPUT  : id -> @PathVariable
	 * R.T    : ResponseEntity<String>
	 * 
	 */
	
	@Operation(summary="Delete the student by id")
	@ApiResponses(
			value= {
					@ApiResponse(
							responseCode="201",description="student has been deleted successfully",
							content = {
									@Content(mediaType="application/json")
							}
							),	
					@ApiResponse(
							responseCode="404",description="student not found",
							content = {
									@Content(mediaType="application/json",schema=@Schema(implementation=ErrorResponse.class))
							}
							)
			}
			)
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id){

		service.deleteRecord(id);
		String status="Student with id "+id+" is DELETED";
		return ResponseEntity.ok(status);
	}
	
	/*
	 * METHOD : PUT
	 * PATH   : /modify
	 * INPUT  : Student -> @RequestBody
	 * R.T    : ResponseEntity<String>
	 * 
	 */
	
	@Operation(summary="update the student object")
	@ApiResponses(
			value= {
					@ApiResponse(
							responseCode="200",description="student has been updated successfully",
							content=@Content(mediaType="plain/text")),
					@ApiResponse(
							responseCode="404",description="student not found",
							content=@Content(mediaType="application/json",schema=@Schema(implementation=ErrorResponse.class)))
					
			}
			)
	@PutMapping("/modify")
	public ResponseEntity<String> updateStudent(
				@RequestBody @Valid Student student
		)
	{
		ResponseEntity<String> response = null;
		try {
			service.updateStudent(student);
			response = ResponseEntity.ok("STUDENT '"+student.getStdId()+"' UPDATED");
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}

}
