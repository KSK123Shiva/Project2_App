package com.javaexpress.jwt;

import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

public interface JwtUtil {

	String generateToken(UserDetails userDetails);
	
	String extractUsername(String token);
	
	Date extractExpirartion(String token);
	
	Boolean validateToken(String token,UserDetails userDetails);
	
	<T> T extractClaims(final String token, Function<Claims, T> claimsResolver);
}
