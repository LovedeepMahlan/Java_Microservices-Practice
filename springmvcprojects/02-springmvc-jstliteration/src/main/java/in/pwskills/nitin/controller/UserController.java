package in.pwskills.nitin.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import in.pwskills.nitin.beans.User;

@RequestMapping(value="/user")
@Controller //HTTP methods(GET/POST) + @Component
public class UserController {

	static {
		System.out.println("UserController.class() is loading");
	}
	
	public UserController() {
		System.out.println("UserControll is Initializing");
	}
	
	@GetMapping("/info")
	public String getInfo(Model model) {
		model.addAttribute("user",new User(12, "Alok", "Developer"));
		model.addAttribute("ListObject",List.of(
				new User(13,"Abhishek","Cyber"),
				new User(14,"Sohan","Data Analist"),
				new User(15,"Sonali","Data Administrtor")
				));
		
		return "UserData";
	}
	
	@GetMapping("/data")
	public String getAllUsers(Model model) {
		model.addAttribute("Name","Sachin");
		model.addAttribute("Team","MI");
		return "UserHome";
	}
}
