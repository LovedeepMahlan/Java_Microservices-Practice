package in.pwskills.nitin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain configurePath(HttpSecurity security) throws Exception {
		return security.authorizeHttpRequests(
				request-> request.requestMatchers("/home","/").permitAll()
				 .requestMatchers("/hello").authenticated()
				 .anyRequest().permitAll()
				
				).formLogin(form->form.loginPage("/login").permitAll())
				.logout(logout->logout.permitAll()).build();
	
}
	
	@Bean
	UserDetailsService getUserDetails() {
		System.out.println("SecurityConfig.userDetailService()::INMEMORY DATA...");
		
		//Creating a User Object
		UserDetails user1=User.withDefaultPasswordEncoder().
				username("Lovedeep").password("choudhary").build();
		
		UserDetails user2=User.withDefaultPasswordEncoder().username("Rohit").password("choudhary").build();
		
		//Storing it in RAM(volatile memory)
		return  new InMemoryUserDetailsManager(user1,user2);
	}
}