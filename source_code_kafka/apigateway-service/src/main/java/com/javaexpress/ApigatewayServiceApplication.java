package com.javaexpress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApigatewayServiceApplication.class, args);
	}

//	@Bean
//	RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//	return builder.routes()
//			.route(p -> p.path("/javaexpress/userms/**")
//			.filters(f ->f.rewritePath("/javaexpress/userms/(?<segment>.*)", "/${segment}"))
//			.uri("lb://USER-SERVICE")).build();
//	}

	@Bean
	MicrometerCapability capability(final MeterRegistry registry) {
		return new MicrometerCapability(registry);
	}

}
