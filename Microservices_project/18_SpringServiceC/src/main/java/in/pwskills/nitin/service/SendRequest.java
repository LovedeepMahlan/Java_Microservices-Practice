package in.pwskills.nitin.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("spring/rest")
public class SendRequest {

	@GetMapping("/showC")
	public String showMsg() {
		return "showC...";
	}
}
