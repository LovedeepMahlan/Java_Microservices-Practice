package in.pwskills.nitin.consumer;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartConsumerApp {

	@Autowired
	public LoadBalancerClient client;
	
	//write a logic to use cart application
	public String getCartAppn(){
		
		//ASK CLIENT TO GET THE INSTANCE WITH LOW LOAD FACTOR USING INSTANCE NAME
		ServiceInstance instance=client.choose("SpringCloudCartService");
		
		//USING SERVICEINSTANCE GET THE URI
		URI uri=instance.getUri();
		
		//create the url using uri and path
		String url=uri+"/rest/controller/show";
		
		RestTemplate template=new RestTemplate();
		ResponseEntity<String> response=template.getForEntity(url, String.class);
		return response.getBody();
	}
}
