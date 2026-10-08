package in.pwskills.nitin.component;

import java.util.UUID;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routing {

	@Bean
	RouteLocator configureRoutes(RouteLocatorBuilder builder) {
		return builder.routes().
		route("CartService",r->r.path("/rest/controller/**")
				.filters(f->f.addRequestHeader("TOCKENID", UUID.randomUUID().toString())
						.addResponseHeader("SERVICESTATUS", "ACTIVE")).uri("lb://SpringCloudCartService")).
		route("OrderService",r->r.path("/spring/rest/**").uri("lb://SpringCloudOrderService-LoadBalancer"))
		.build();
	}
}
