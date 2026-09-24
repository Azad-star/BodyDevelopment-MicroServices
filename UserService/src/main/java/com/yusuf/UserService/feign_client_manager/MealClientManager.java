package com.yusuf.UserService.feign_client_manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url="http://localhost:8082/rest-api/userMealPlan", name = "mealClientManager")
public interface MealClientManager {
	
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteUserMealPlan(@RequestParam("userId") Long userId);

}
