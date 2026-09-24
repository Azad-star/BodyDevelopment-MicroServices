package com.yusuf.MealService.security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter{
	
	private final JwtUtil jwtUtil;
	
	@Value("${internal.secret}")
	private String internalSecret;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

        String internalHeader = request.getHeader("X-Internal-Secret");
        
        if (internalHeader != null && internalHeader.equals(internalSecret)) {
            UsernamePasswordAuthenticationToken systemAuth = new UsernamePasswordAuthenticationToken("internal-system", null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(systemAuth);
            filterChain.doFilter(request, response);
            return; 
        }
        
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            if (jwtUtil.isTokenValid(token)) {
                String userId = jwtUtil.extractUserId(token);
                UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(userId, null, new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(userAuth);
            }
        }
        
        filterChain.doFilter(request, response);
	}
	

}
