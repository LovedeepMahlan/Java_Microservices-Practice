package in.pwskills.nitin.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller //HTTP methods(GET/POST) + @Component
@RequestMapping("/springmaven")
public class WelcomeController {

	static {
		System.out.println("WelcomeController.class() is loading");
	}
	
	public WelcomeController() {
		System.out.println("WelcomeController.WelcomeController() is initializing");
	}
	
	/**
	 * 1. REQUEST TYPE :: GET/POST
	 * 2. PATH         :: URL
	 * 3. MODEL   	   :: Sending the data from Controller to View
	 * 4. R.T          :: ViewName(with no technology details)
	 * 
	 */
	//@RequestMapping(value = "/",method = RequestMethod.GET)
	@GetMapping(value="/info")
	public String getMethodName(Map<String, String> model) {
		System.out.println(model.getClass().getName());
		model.put("BRAND", "PWSKILLS");//we can use Model(I),MAP(I),ModelMap(c) to send the data
		
		return "Welcome";
	}
	
}
