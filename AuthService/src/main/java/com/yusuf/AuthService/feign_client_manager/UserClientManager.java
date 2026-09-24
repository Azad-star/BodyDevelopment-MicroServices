package com.yusuf.AuthService.feign_client_manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yusuf.AuthService.dto.UserAuthDto;

@FeignClient(url = "http://localhost:8080/rest-api/user" ,name = "userClientManager")
public interface UserClientManager {
	
	@GetMapping("/get-for-auth")
	public ResponseEntity<UserAuthDto> getUserByEmailForAuth(@RequestParam("email") String email);

}
