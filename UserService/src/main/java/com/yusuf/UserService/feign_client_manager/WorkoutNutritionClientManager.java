package com.yusuf.UserService.feign_client_manager;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.yusuf.UserService.dto.UserDataDto;

@FeignClient(url="http://localhost:8081/rest-api/workoutPlanAndNutrition", name = "workoutNutritionClientManager")
public interface WorkoutNutritionClientManager {
	
	@PostMapping("/create")
	public ResponseEntity<Boolean> setExerciseAndNutrition(@RequestBody UserDataDto userData );
	
	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteExerciseAndNutrition(@RequestParam("userId") Long userId);

}
