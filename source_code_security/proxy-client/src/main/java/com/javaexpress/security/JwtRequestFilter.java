package com.javaexpress.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.javaexpress.jwt.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("** JWTRequestFilter, once per request,Validtating and extracting token");
		String header = request.getHeader("Authorization");
		String jwtToken = null;
		String username = null;
		
		if(header != null && header.startsWith("Bearer ")) {
			jwtToken = header.substring(7);
			username = jwtUtil.extractUsername(jwtToken);
		}
		log.info("JWT Token :: username {} ",username);
		
		if(username != null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			
			if(jwtUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken obj = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), 
						null,userDetails.getAuthorities());
				
				obj.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(obj);
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
