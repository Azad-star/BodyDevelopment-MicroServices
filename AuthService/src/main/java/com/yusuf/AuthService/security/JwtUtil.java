package com.yusuf.AuthService.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	// GitHub'daki konfigürasyondan gizli anahtarımızı ve süreyi çekiyoruz
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expires-in}")
	private Long expirationTime;
	
	// String halindeki gizli anahtarımızı, JJWT kütüphanesinin anlayacağı kriptografik bir Key nesnesine çeviriyoruz
	private Key getSigningKey() {
		// Düz metin yerine, Base64 formatındaki şifreyi çözerek kriptografik anahtar üretiyoruz
		byte[] keyBytes = Decoders.BASE64.decode(secret);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	public String generateToken(String userId) {
		return Jwts.builder()
                .setSubject(userId) // Biletin sahibi kim? (Kimlik)
                .setIssuedAt(new Date(System.currentTimeMillis())) // Bilet ne zaman kesildi? (Şu an)
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // Ne zaman bitecek? (Şu an + 24 saat)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // Hangi gizli mühürle mühürlendi?
                .compact(); // Hepsini birleştir ve String olarak ver!
	}
}
