package com.yusuf.UserService.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	@Value("${jwt.secret}")
	private String secretKey;
	
	public String extractUserId(String token) {
		Claims claims = extractAllClaims(token);
		
		return claims.getSubject();
	}
	
	public boolean isTokenValid(String token) {
		try {
			
			Claims claims = extractAllClaims(token);
			Date expirationDate = claims.getExpiration();
			return expirationDate.after(new Date());
			
		} catch (Exception e) {
			System.out.println("TOKEN GEÇERSİZ NEDENİ: " + e.getMessage());
			return false;
		}
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getSigInKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

	private Key getSigInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
