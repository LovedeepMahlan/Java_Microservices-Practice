package in.pwskills.nitin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.CurrencyResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value="/rest/controller")
public class ResponseGenerator {

@GetMapping("/convertcurrency/from/{from}/to/{to}")
public ResponseEntity<CurrencyResponse> convertCurrency(@PathVariable String from,
													   @PathVariable String to) {
	CurrencyResponse response=new CurrencyResponse();
	response.setCurrencyFrom(from);
	response.setCurrencyId(1);
	response.setCurrencyTo(to);
	response.setCurrencyValue(83);
	
	try {
		Thread.sleep(30000);
	}catch(Exception e) {
		e.printStackTrace();
	}
    return ResponseEntity.ok(response);
}

}
