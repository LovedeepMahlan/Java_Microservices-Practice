package in.pwskills.nitin.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.pwskills.nitin.bean.StockApi;
import in.pwskills.nitin.convertor.JsonUtil;
import in.pwskills.nitin.service.providerService;

@RestController
@RequestMapping("/rest/controller")
public class RestProvider {

	@Autowired
	providerService service;
	
	/***
	 * METHOD : GET
	 * INPUT  : code,cost(@RequestParam)
	 * OUTPUT : String
	 * path   : /send
	 */
	
	@GetMapping("/send")
	public String readInput(
			 @RequestParam  Double cost,
			 @RequestParam  String code
			) {
		StockApi api=new StockApi();
		
		//Create an object holding cost and code
		api.setStkCode(code);
		api.setStkCost(cost);
		
		System.out.println(api);
		//Convert object to jsonString format and send it to Service
		String message=JsonUtil.convertObjectToJson(api);
		System.out.println(message);
		
		if (message != null) {
			service.sendMessage(message);
			return "SUCCESS";
			
		}else {
			return "FAILURE";
		}
		
	}
	
}
