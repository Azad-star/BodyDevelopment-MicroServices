package com.yusuf.MealService.feign_client_manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yusuf.MealService.enums.FitnessGoal;

@FeignClient(url="http://localhost:8080/rest-api/user", name ="clientManager")
public interface UserClientManager {
	
	@GetMapping("/get/fitness-goal")
	public ResponseEntity<FitnessGoal> getUserFitnessGoal(@RequestParam("userId") Long userId);

}
