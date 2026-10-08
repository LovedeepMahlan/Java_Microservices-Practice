package in.pwskills.nitin.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.response.Cart;

@RestController
@RequestMapping("/rest/controller")
@RefreshScope
public class CartRestController {

	@Value("${server.port}")
	private String portNo;
	
	@Value("${my.app.title}")
	private String info;
	
	/*
	 * METHOD  : GET
	 * PATH    : /show
	 * OUTPUT  : R.E<String>
	 * URL     : /v1/api/cart/show
	 * INPUT   : RequestHeader(TOKENID)
	 * 
	 */
	
	@GetMapping("/show")//@RequestHeader("TOCKENID")String tockeninfo  this creates problem to run this pirticular request at show
	//this will run only with project 15 api gateway because in which we add requestHeader for TockenId
	public ResponseEntity<String> getCartDetails(
			@RequestHeader("TOCKENID")String tockeninfo){
		return ResponseEntity.ok("WELCOME TO CART SERVICE RUNNING ON :: "+portNo+" Data retrived from --> "+info
				+ "prefilter data of api gateway is "+tockeninfo
);
	}
	
	/*
	 * METHOD  : GET
	 * PATH    : /find
	 * OUTPUT  : R.E<Cart>
	 * INPUT   : id (@Pathvariable)
	 * URL     : /v1/api/cart/find/{id}
	 * 
	 */
	@GetMapping("/find/{id}")
	public ResponseEntity<String> getCartById(
				@PathVariable Integer id) {
		Cart cart = new Cart();
		cart.setCartId(id);
		cart.setCartCost(2300.0);
		cart.setCartCode("TEST");
		
		return ResponseEntity.ok(cart.toString()+"PORT OF CART:: "+portNo);
	}
	
	/*
	 * METHOD  : POST
	 * PATH    : /create
	 * OUTPUT  : R.E<String>
	 * INPUT   : Cart (@Requestbody)
	 * URL     : /v1/api/cart/create
	 * 
	 */
	
	@PostMapping("/create")
	public ResponseEntity<String> addToCart(
			@RequestBody Cart cart) {
		return ResponseEntity.ok("ADDED TO CART => " + cart);
		
	}
}

