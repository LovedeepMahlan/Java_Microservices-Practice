package in.pwskills.nitin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.Cart;
import in.pwskills.nitin.consumer.ICartConsumer;

@RestController
@RequestMapping("/rest/controller")
public class OrderRestController {

	@Autowired
	public ICartConsumer consumer;
	
	@Value("${server.port}")
	Integer portNo;
	
	/*
	 * METHOD  : GET
	 * PATH    : /place
	 * OUTPUT  : R.E<String>
	 * URL     : /v1/api/order/place
	 * 
	 */
	
	@GetMapping("/place")
	public ResponseEntity<String> placeOrder(){
		String cartResponse=consumer.getCartInfo().getBody();
		return ResponseEntity.ok(cartResponse);
	}
	
	/*
	 * METHOD  : GET
	 * PATH    : /find/{id}
	 * OUTPUT  : R.E<String>
	 * URL     : /rest/controller/find/{id}
	 * 
	 */
	
	@GetMapping("/find/{id}")
	public ResponseEntity<String> fetchOrderById(@PathVariable Integer id){
		String cob=consumer.getCartById(id).getBody();
		return ResponseEntity.ok("PORT NO OF ORDER IS :: "+portNo +"   ORDER WITH CART DATA => " + cob  );
	}
	
	
	/*
	 * METHOD  : GET
	 * PATH    : /find/{id}
	 * OUTPUT  : R.E<String>
	 * URL     : /rest/controller/find/{id}
	 * 
	 */
	
	@PostMapping("/addtocart")
	public ResponseEntity<String> addToCart(@RequestBody Cart cart){
		String cob=consumer.addCartDetails(cart).getBody();
		return ResponseEntity.ok(cob);
	}
}
