package in.pwskills.nitin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.Product;
import in.pwskills.nitin.bean.ProductNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping(value="/spring/rest")
public class SpringController {
	
	/*
	 * METHOD :GET
	 * PATH   :/one/{id}
	 * INPUT  : id(@Pathvariable)
	 * R.T    : ResponseEntity<String>
	 * 
	 */
	@GetMapping("one/{id}")
	public ResponseEntity<String> getProduct(@PathVariable Integer id) {
		if(id==12) {
			return new ResponseEntity<>("Product Exist",HttpStatus.OK);
		}
		else {
			throw new RuntimeException("Product not found for id "+id);
		}
	}
	
	//CASE 2: Sending ResponseEntity<String> or ResponseEntity<String>
	@GetMapping("two/{id}")
	public ResponseEntity<String> getProductbyId(@PathVariable Integer id) {
		if(id==12) {
			
			Product product=new Product(12, "MicroServices",12000.0f);
			return new ResponseEntity<>(product.toString(),HttpStatus.OK);
		}
		else {
			throw new ProductNotFoundException("Product not found for id "+id);
		}
	}
	
	/* CASE-3 : Sending ResponseEntity<Product> or ResponseEntity<MyErrorResponse>
	 * METHOD :GET
	 * PATH   :/one/{id}
	 * INPUT  : id(@Pathvariable)
	 * R.T    : ResponseEntity<Product> | ResponseEntity<MyErrorResponse>
	 * 
	 */
	
	@GetMapping("three/{id}")
	public ResponseEntity<String> getProductbyI(@PathVariable Integer id) {
		if(id==12) {
			Product product=new Product(12, "MicroServices",12000.0f);
			return new ResponseEntity<>(product.toString(),HttpStatus.OK);
		}
		else {
			throw new ProductNotFoundException("Product not found for id "+id);
		}
	}
	
	
}
