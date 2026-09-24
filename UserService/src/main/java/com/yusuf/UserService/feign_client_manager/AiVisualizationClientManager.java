package com.yusuf.UserService.feign_client_manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url="http://localhost:8083/rest-api/ai-visualization", name = "aiVisualizationClientManager")
public interface AiVisualizationClientManager {
	
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteImage(@RequestParam("userId") Long userId);

}
