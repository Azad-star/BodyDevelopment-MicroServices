package com.yusuf.AuthService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yusuf.AuthService.controller.interfaces.IAuthController;
import com.yusuf.AuthService.entity.LoginRequest;
import com.yusuf.AuthService.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-api/auth")
public class AuthController implements IAuthController {

	private final AuthService authService;
	
	@PostMapping("/login")
	@Override
	public ResponseEntity<String> login(@RequestBody LoginRequest request) {
		
		try {
			String token = authService.login(request);
			return ResponseEntity.ok(token);
			
		} catch (Exception e) {
			return ResponseEntity.status(401).body(e.getMessage());
		}
	}
	

}
