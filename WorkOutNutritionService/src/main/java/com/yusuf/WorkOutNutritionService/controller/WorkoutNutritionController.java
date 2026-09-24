package com.yusuf.WorkOutNutritionService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yusuf.WorkOutNutritionService.controller.interfaces.IWorkoutNutritionController;
import com.yusuf.WorkOutNutritionService.dto.UserDataDto;
import com.yusuf.WorkOutNutritionService.service.interfaces.IWorkoutNutritionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-api/workoutPlanAndNutrition")
public class WorkoutNutritionController implements IWorkoutNutritionController {
	
	private final IWorkoutNutritionService service;
	
	@PostMapping("/create")
	@Override	
	public ResponseEntity<Boolean> setExerciseAndNutrition(@RequestBody UserDataDto userdata) {
		return ResponseEntity.ok(service.setExerciseAndNutrition(userdata));
	}
	
	@DeleteMapping("/delete")
	@Override
	public ResponseEntity<Boolean> deleteExerciseAndNutrition(@RequestParam("userId") Long userId) {
		return ResponseEntity.ok(service.deleteExerciseAndNutrition(userId));
	}

}
