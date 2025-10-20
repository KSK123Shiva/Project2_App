package com.javaexpress.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtilImpl implements JwtUtil{
	
	private static final String SECRET_KEY = "secret";

	@Override
	public String generateToken(UserDetails userDetails) {
		final Map<String, Object> claims = new HashMap<>();
		claims.put("client", "javaexpress");
		claims.put("roles", userDetails.getAuthorities());
		log.info("generate Token for this user {} ",userDetails.getUsername());
		return Jwts.builder()
			.setClaims(claims)
			.setSubject(userDetails.getUsername())
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 ))
			.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}

	
//	public String generateToken(final UserDetails userDetails) {
//		final Map<String, Object> claims = new HashMap<>();
//		return this.createToken(claims, userDetails.getUsername());
//	}
//	
//	private String createToken(final Map<String, Object> claims, final String subject) {
//		return Jwts.builder()
//					.setClaims(claims)
//					.setSubject(subject)
//					.setIssuedAt(new Date(System.currentTimeMillis()))
//					.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//					.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//		.compact();
//	}
//	
	public <T> T extractClaims(final String token, Function<Claims, T> claimsResolver) {
		final Claims claims = this.extractClaims(token);
		return claimsResolver.apply(claims);
	}
	
	public Claims extractClaims(String token) {
		Claims claims = Jwts.parser().setSigningKey(SECRET_KEY)
				.parseClaimsJws(token).getBody();
		return claims;
	}
	
	
	@Override
	public String extractUsername(String token) {
		return extractClaims(token,Claims::getSubject);
	}

	@Override
	public Date extractExpirartion(String token) {
		return extractClaims(token,Claims::getExpiration);
	}

	@Override
	public Boolean validateToken(String token, UserDetails userDetails) {
		String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private Boolean isTokenExpired(String token) {
		return extractExpirartion(token).before(new Date());
	}

	
}
