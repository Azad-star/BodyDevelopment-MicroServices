package com.yusuf.AuthService.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.yusuf.AuthService.entity.LoginRequest;

public interface IAuthController {
	
	public ResponseEntity<String> login(LoginRequest request);

}
