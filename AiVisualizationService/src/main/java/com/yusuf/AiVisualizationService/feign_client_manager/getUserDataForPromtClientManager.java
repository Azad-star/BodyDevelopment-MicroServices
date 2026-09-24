package com.yusuf.AiVisualizationService.feign_client_manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yusuf.AiVisualizationService.config.FeignConfig;
import com.yusuf.AiVisualizationService.dto.UserDataDto;

@FeignClient(url="http://localhost:8080/rest-api/user", name = "clientManager", configuration = FeignConfig.class)
public interface getUserDataForPromtClientManager {
	
	@GetMapping("/get")
	public ResponseEntity<UserDataDto> getUser(@RequestParam("userId") Long userId);


}
