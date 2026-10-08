package in.pwskills.nitin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.StockApi;
import in.pwskills.nitin.db.MessageStore;

@RestController
@RequestMapping("/vi/stock/api")
public class StockRestController {

	@Autowired
	MessageStore store;
	
	/*
	 * METHOD : GET
	 * PATH   : /all
	 * INPUT  : noinput
	 * R.T    : List<StockApi>
	 */
	
	@GetMapping("/getAll")
	public List<StockApi> getAllObj(){
		return store.getAllObj();
		
	}
}
