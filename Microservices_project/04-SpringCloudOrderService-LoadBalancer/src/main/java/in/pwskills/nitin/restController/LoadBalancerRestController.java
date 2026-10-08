package in.pwskills.nitin.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.pwskills.nitin.consumer.CartConsumerApp;

@RestController
@RequestMapping("/spring/rest")
public class LoadBalancerRestController {

	@Autowired
	CartConsumerApp consumer;
	 
	@GetMapping("/putOrder")
	public String consumeCartAppn() {
		String response=consumer.getCartAppn();
		return response;
	}
}
