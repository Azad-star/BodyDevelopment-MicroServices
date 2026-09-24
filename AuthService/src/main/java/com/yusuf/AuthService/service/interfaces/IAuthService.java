package com.yusuf.AuthService.service.interfaces;

import com.yusuf.AuthService.entity.LoginRequest;

public interface IAuthService {
	
	public String login(LoginRequest request) throws Exception;

}
