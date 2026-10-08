package in.pwskills.nitin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.pwskills.nitin.beans.Book;
import in.pwskills.nitin.repo.BookIdRepo;

@RestController
@RequestMapping(value="/rest/controller")
public class IBookController {

	@Autowired
	BookIdRepo repo;
	
	@PostMapping("/save")
	public ResponseEntity<String> addBook(@RequestBody Book book){
		
		repo.save(book);
		System.out.println(book.toString());
		String body="Book of id "+book.getBId()+" created";
		return new ResponseEntity<>(body,HttpStatus.CREATED);
	}
}
