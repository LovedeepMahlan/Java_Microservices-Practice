package in.pwskills.nitin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.Beans.Role;
import in.pwskills.nitin.Beans.User;

@RestController
@RequestMapping(value="/spring/rest")
public class SpringRestController {

	/*
	 * R.T    : ResponseEntity<User>
	 * INPUT  : No input
	 * METHOD : GET
	 * PATH  : /user
	 */
	@PostMapping(value="/user")
	public ResponseEntity<User> getUser(){
		User user =new User(1, "Rohit", List.of("Amit","Ronak","Preetam"), Map.of("SBI",123346456,"HDFC",567569876));
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	
	/*
	 * R.T    : ResponseEntity<List<Role>>
	 * INPUT  : No input
	 * METHOD : GET
	 * PATH  : /list 
	 */
	@GetMapping(value="/list")
	public ResponseEntity<List<Role>> getRoleList(){
		Role role1=new Role("Chaman", "Developer");
		Role role2=new Role("Abhishek", "Hacker");
		Role role3=new Role("Animika","DataAnalist");
		List<Role> list=List.of(role1,role2,role3);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	/*
	 * R.T    : ResponseEntity<Map<Role>>
	 * INPUT  : No input
	 * METHOD : GET
	 * PATH  : /map
	 */
	@GetMapping(value="/map")
	public ResponseEntity<Map<String, Role>> getRoleMap(){
		Role role1=new Role("Chaman", "Developer");
		Role role2=new Role("Abhishek", "Hacker");
		Role role3=new Role("Animika","DataAnalist");
		Map<String, Role> map=Map.of("role1",role1,"role2",role2,"role3",role3);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
}
