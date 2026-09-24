package com.yusuf.AuthService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean  // Şifre karşılaştırması yapmak için bu araca ihtiyacımız var
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
        .csrf(csrf -> csrf.disable()) 
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/rest-api/auth/login").permitAll() // Giriş kapısı herkese açık!
            .requestMatchers("/error").permitAll()// HAYAT KURTARAN SATIR: Hataları görmemize izin ver!
            .anyRequest().authenticated() // Diğer her yer kapalı
        );
    return http.build();
}
}
