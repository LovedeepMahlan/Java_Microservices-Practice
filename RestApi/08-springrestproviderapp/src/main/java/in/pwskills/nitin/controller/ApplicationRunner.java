package in.pwskills.nitin.controller;


import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import in.pwskills.nitin.bean.Book;

@Component
public class ApplicationRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		final String url=   "http://localhost:8888/spring/rest/showA";
		final String url2=  "http://localhost:8888/spring/rest/showB/{name}/{id}";
		final String url3=  "http://localhost:8888/spring/rest/showC/{id}";
		final String url4=  "http://localhost:8888/spring/rest/showD";
		final String url5 = "http://localhost:8888/spring/rest/showE";
		final String url6 = "http://localhost:8888/spring/rest/showF/{id}";
		
		RestTemplate template=new RestTemplate();
		
		ResponseEntity<String> response1=template.exchange(
				url,
				HttpMethod.GET,
				null,//here we can send body or header
				String.class);//this is the return type
		System.out.println(response1.getBody());
		System.out.println(response1.getHeaders());
		System.out.println(response1.getStatusCode());
		
		System.out.println("******************************************************************************");
		
		//send path variable in url 
		ResponseEntity<String> response2=template.exchange(
				url2,
				HttpMethod.GET,
				null,
				String.class,
				"Microservices",//pathvariable
				23);//pathvariable
		
		System.out.println(response2.getBody());
		System.out.println(response2.getHeaders());
		System.out.println(response2.getStatusCode());
		
		System.out.println("******************************************************************************");
		
		ResponseEntity<Book> response3=template.exchange(
				url3,
				HttpMethod.GET,
				null,
				Book.class,
				23);
		
		System.out.println(response3.getBody());
		System.out.println(response3.getHeaders());
		System.out.println(response3.getStatusCode());
		
		System.out.println("******************************************************************************");
		
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		String body="{\r\n" + "    \"bid\": 23,\r\n" + "    \"bname\": \"SBMS\",\r\n"
				+ "    \"bauth\": \"GaganDeep\",\r\n" + "    \"bcost\": 5000.0\r\n" + "}";
		
		HttpEntity<String> entity=new HttpEntity(body,header);
		
		ResponseEntity<String> response4=template.exchange(
				url4,
				HttpMethod.POST,
				entity,
				String.class);
		System.out.println(response4.getBody());
		System.out.println(response4.getHeaders());
		System.out.println(response4.getStatusCode());
		
		System.out.println("******************************************************************************");

		HttpHeaders headers2 = new HttpHeaders();
		headers2.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonbody = "{\r\n"
				+ "    \"bid\": 25,\r\n"
				+ "    \"bname\": \"SBMS\",\r\n"
				+ "    \"bauth\": \"GaganDeep\",\r\n"
				+ "    \"bcost\": 5000.0\r\n"
				+ "}";
		
		HttpEntity<String> entity2 = new HttpEntity<>(jsonbody,headers2);
		
		ResponseEntity<String> response5 = template.exchange(
				 url5,
				 HttpMethod.PUT,
				 entity2,
				 String.class
				);
		
		// Reading the response details from the object
		System.out.println(response5.getBody());
		System.out.println(response5.getHeaders());
		System.out.println(response5.getStatusCode().value());
		
		System.out.println("******************************************************************************");

		//Case5 : Sending DELETE request using exchange(,,,,,,)
				ResponseEntity<String> response6 = template.exchange(
						url6, 
						HttpMethod.DELETE, 
						null, 
						String.class,
						10);
				
				// Reading the response details from the object
				System.out.println(response6.getBody());
				System.out.println(response6.getHeaders());
				System.out.println(response6.getStatusCode().value());
				
				System.out.println("******************************************************************************");
	}

}
