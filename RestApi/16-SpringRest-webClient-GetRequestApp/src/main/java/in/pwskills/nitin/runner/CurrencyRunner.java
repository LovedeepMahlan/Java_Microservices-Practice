package in.pwskills.nitin.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import in.pwskills.nitin.bean.CurrencyResponse;

@Component
public class CurrencyRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		invokeWebClientSync("USD","INR");
		invokeWebClientASync("USD","INR");
	}

	private void invokeWebClientASync(String from, String to) {
		
String url="http://localhost:9999/rest/controller/convertcurrency/from/{from}/to/{to}";
		
		WebClient client=WebClient.create();
		
		System.out.println("WebClient Request is generating");
		
		       client.get().
			   uri(url,from,to).
			   retrieve().
			   bodyToMono(CurrencyResponse.class).
			   subscribe(CurrencyRunner::consumeInput);
		
		System.out.println("REsponse has been generated");
	}
	public static void consumeInput(CurrencyResponse response) {
		System.out.println(response);
	}
	private void invokeWebClientSync(String from, String to) {
		String url="http://localhost:9999/rest/controller/convertcurrency/from/{from}/to/{to}";
		
		WebClient client=WebClient.create();
		
		System.out.println("WebClient Request is generating");
		
		CurrencyResponse response= client.get().
			   uri(url,from,to).
			   retrieve().
			   bodyToMono(CurrencyResponse.class).
			   block();
		
		System.out.println("REsponse has been generated");
		System.out.println(response);
		
	}

}
