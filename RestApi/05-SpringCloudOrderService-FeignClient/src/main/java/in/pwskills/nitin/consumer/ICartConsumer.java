package in.pwskills.nitin.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.pwskills.nitin.bean.Cart;

@FeignClient("SpringCloudCartService")
public interface ICartConsumer {

	@GetMapping("/rest/controller/show")
	public ResponseEntity<String> getCartInfo();
	
	@GetMapping("/rest/controller/find/{id}")
	public ResponseEntity<String> getCartById(@PathVariable Integer id);
	
	@PostMapping("/rest/controller/create")
	public ResponseEntity<String> addCartDetails(@RequestBody Cart cart);
}
