package in.pwskills.nitin.rest;

import java.util.Enumeration;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/rest/controller")
public class ProductRestController{
	
	/*
	 * R.T    : ResponseEntity<String>
	 * METHOD : GET
	 * PATH   : /get -> static path , {pid}/{pname} -> dynamic path
	 * INPUT  : No input
	 * 
	 */
	@GetMapping(value="/get/{id}/{name}")
	public ResponseEntity<String> getRequestParam(@PathVariable String name,
												@PathVariable(required=false) Integer id){
												//required=false) if path variable is exist then add it else give null
			String body = "PID = "+id + " : "+"PNAME = "+name;
		return new ResponseEntity(body, HttpStatus.OK);
		//ResponeEntity.ok(body)  we can use this also
	}
	
	/*
	 * R.T    : ResponseEntity<String>
	 * METHOD : find
	 * PATH   : /get -> static path 
	 * INPUT  : @RequestParam (pid,pname)
	 * 
	 */
	
	@GetMapping("/find")
	public ResponseEntity<String> getMethodName(@RequestParam String name,
												@RequestParam(required = false) Integer id) {
		String body = "PID = "+id + " : "+"PNAME = "+name;
		return ResponseEntity.ok(body);
	}
	
	/*
	 * R.T    : ResponseEntity<String>
	 * METHOD : GET
	 * PATH   : /load -> static path 
	 * INPUT  : No Input
	 * 
	 */
	
	@GetMapping("/load")
	public ResponseEntity<String> getMethodName(@RequestHeader Map<String, String> header) {
		
		header.forEach((key,value)->{
			System.out.println(String.format("Key = %s  and value =%s",key,value));
		});
		return new ResponseEntity<String>(String.format("Listed  %d Headers ",header.size()),HttpStatus.OK);
	}
	
	/*
	 * R.T    : ResponseEntity<String>
	 * METHOD : GET
	 * PATH   : /info -> static path 
	 * INPUT  : No Input
	 * 
	 */
	@GetMapping("/info")
	public ResponseEntity<String> getHeaderDetails(
				HttpServletRequest request
			) {
		
		Enumeration<String> names = request.getHeaderNames();
		String name = "";
		String value = "";
		String body = "";
		while (names.hasMoreElements()) {
			name = (String) names.nextElement();
			value = request.getHeader(name);
		 	System.out.println(name + ": " + value);
		 	body+=name + ": "+value +"\n";
		}
		return  new ResponseEntity<String>(body,HttpStatus.OK);
	}	
	
	
}