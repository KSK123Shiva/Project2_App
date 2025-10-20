package com.javaexpress.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.javaexpress.user.model.RoleBasedAuthrority;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.cors(cors -> cors.disable())
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/authenticate/**","/api/authenticate").permitAll()
				.requestMatchers("/api/users/**").permitAll()
				.requestMatchers("/api/categories/**").authenticated()
				.requestMatchers("/api/products/**").authenticated()
				.requestMatchers("/api/orders/**").authenticated()
				.requestMatchers("/api/**")
				.hasAnyRole(RoleBasedAuthrority.ROLE_USER.getRole(), 
						RoleBasedAuthrority.ROLE_ADMIN.getRole())
				.anyRequest().authenticated())
				.sessionManagement(session -> session
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
	
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
}

//Bean Level Classes