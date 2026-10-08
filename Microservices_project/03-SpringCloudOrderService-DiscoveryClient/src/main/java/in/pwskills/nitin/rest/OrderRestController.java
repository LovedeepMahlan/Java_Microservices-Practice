package in.pwskills.nitin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.consumer.CartConsumerApp;

@RestController
@RequestMapping("/rest/controller")
public class OrderRestController {

	@Autowired
	CartConsumerApp consumer;
	
	@GetMapping("/placeOrder")
	public ResponseEntity<String> placeOrder(){
		String cartResponse=consumer.getCartService();
		return ResponseEntity.ok(cartResponse);
	}
}
