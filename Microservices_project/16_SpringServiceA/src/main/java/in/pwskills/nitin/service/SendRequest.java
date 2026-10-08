package in.pwskills.nitin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("spring/rest")
public class SendRequest {

	@Autowired
	RestTemplate rt;
	
	@GetMapping("/showA")
	public String showMsg() {
		String resp=rt.getForEntity("http://localhost:8002/spring/rest/showB", String.class).getBody();
		
		return "showA..."+resp;
	}
}
