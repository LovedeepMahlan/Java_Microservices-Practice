package in.pwskills.nitin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigRestTemplate {

	@Bean
	RestTemplate getrestTemplate() {
		return new RestTemplate();
	}
}
