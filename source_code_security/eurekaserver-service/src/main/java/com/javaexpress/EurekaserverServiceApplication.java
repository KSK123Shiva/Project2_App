package com.javaexpress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import feign.micrometer.MicrometerCapability;
import io.micrometer.core.instrument.MeterRegistry;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverServiceApplication.class, args);
	}
	
	@Bean
	MicrometerCapability capability(final MeterRegistry registry) {
		return new MicrometerCapability(registry);
	}

}
