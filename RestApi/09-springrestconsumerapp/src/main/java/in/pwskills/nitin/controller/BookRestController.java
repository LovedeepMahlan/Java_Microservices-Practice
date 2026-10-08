package in.pwskills.nitin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.Book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/spring/rest")
public class BookRestController {

	/*
	 * METHOD : GET
	 * PATH   : /showA
	 * R.T    : ResponseEntity<String>
	 * INPUT  : no input
	 */
	
	@GetMapping("/showA")
	public ResponseEntity<String> getURL1() {
		return ResponseEntity.ok("Welcome to first request GET");
	}

	/*
	 * METHOD : GET
	 * PATH   : /showB
	 * R.T    : ResponseEntity<String>
	 * INPUT  : name,id
	 */
	@GetMapping("showB/{name}/{id}")
	public ResponseEntity<String> getURL2( @PathVariable String name,
							@PathVariable Integer id) {
		String str=String.format("name is %s and id is %d",name,id);
		return ResponseEntity.ok(str);
	}
	
	/*
	 * METHOD : GET
	 * PATH   : /showC
	 * R.T    : ResponseEntity<Book>
	 * INPUT  : id
	 */
	
	@GetMapping("/showC/{id}")
	public ResponseEntity<Book> getURL3(@PathVariable Integer id){
		
		Book book=new Book(id, "Microservices", "Micradfig", 12000.0);
		
		return ResponseEntity.ok(book);
	}
	
	/*
	 * METHOD : POST
	 * PATH   : /showD
	 * R.T    : ResponseEntity<String>
	 * INPUT  : @RequestBody Book
	 */
	@PostMapping("/showD")
	public ResponseEntity<String> showMgs4(
			@RequestBody Book book
			) 
	{
		return ResponseEntity.ok("Data given is " + book);
	}
	
	/*
	 * METHOD : PUT
	 * PATH   : /showE
	 * R.T    : ResponseEntity<String>
	 * INPUT  : @RequestBody Book
	 */
	@PutMapping("/showE")
	public ResponseEntity<String> showMgs5(
			@RequestBody Book book
			) 
	{
		return ResponseEntity.ok("Data FROM PUT is " + book);
	}
	
	
	/*
	 * METHOD : DELETE
	 * PATH   : /showF
	 * R.T    : ResponseEntity<String>
	 * INPUT  : id(@PathVariable)
	 */
	@DeleteMapping("/showF/{id}")
	public ResponseEntity<String> showMsg6(
			@PathVariable  Integer id
			) 
	{
		return ResponseEntity.ok("DELETE MAPPING " + id);
	}

}
