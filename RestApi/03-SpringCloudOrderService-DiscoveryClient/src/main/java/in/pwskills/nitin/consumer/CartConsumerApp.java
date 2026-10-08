package in.pwskills.nitin.consumer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartConsumerApp {

	@Autowired
	public DiscoveryClient client;
	
	//Write a logic to consume the other service
	public String getCartService() {

		//GET THE DETAILS BASED ON SERVICE NAME
		List<ServiceInstance> instance=client.getInstances("SpringCloudCartService");
		
		//GET THE DETAILS OF 0TH INDEX 
		ServiceInstance ins=instance.get(0);
		
		//GET URI ON THE BASE OF INSTANCE
		URI uri=ins.getUri();
		System.out.println(uri);
		
		//CREATE THE URL WITH THE HELP OF URI
		String url=uri+"/rest/controller/show";
		
		//sending the request with the help of resttemplate
		RestTemplate template=new RestTemplate();
		ResponseEntity<String> entity=template.getForEntity(url, String.class);
		
		return entity.getBody();
	}
}
