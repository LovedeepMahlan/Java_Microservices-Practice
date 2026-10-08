package in.pwskills.nitin.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ApplicatiionConfig {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	SecurityFilterChain configPath(HttpSecurity security) throws Exception {
		return security.authorizeHttpRequests(
				request->request.requestMatchers("/home","/").permitAll()
								.requestMatchers("/hello").authenticated()
								.requestMatchers("/admin").hasAuthority("ADMIN")
								.requestMatchers("/customer").hasAuthority("CUSTOMER")
				).formLogin(form->form.loginPage("/login").permitAll())
				.logout(logout->logout.permitAll()).build();
	}
	
	@Bean
	UserDetailsService service(DataSource datasource) {
		UserDetails user1=User.withUsername("Anushka").password(
				passwordEncoder.encode("kohli")).authorities("ADMIN").build();
		UserDetails user2=User.withUsername("Sara").password("$2a$12$JLAJLQeAt79.4yEgoOfZ8.KZYkP1w2Idm9iD.iWXqtXiTpD.bJ24a").authorities("CUSTOMER").build();
		
		JdbcUserDetailsManager manager=new JdbcUserDetailsManager(datasource);
		manager.createUser(user2);
		manager.createUser(user1);
		
		return manager;
	}
}
