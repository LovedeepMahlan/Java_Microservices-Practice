package in.pwskills.nitin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SerurityController {

	// requestMatcher("/home","/").permitAll()
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	// requestMatcher("/hello").authenticated()
	@GetMapping("/hello")
	public String getMethodName() {
		return "hello";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	// ONLY ADMIN After login
	// .antMatchers("/admin").hasAuthority("ADMIN")
	@GetMapping("/admin")
	public String adminPage() {
		return "admin";
	}
	
	// ONLY CUSTOMER After login
	// .antMatchers("/customer").hasAuthority("CUSTOMER")
	@GetMapping("/customer")
	public String customerPage() {
		return "customer";
	}
}
