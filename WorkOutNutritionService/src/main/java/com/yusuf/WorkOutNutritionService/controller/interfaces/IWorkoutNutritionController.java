package com.yusuf.WorkOutNutritionService.controller.interfaces;

import org.springframework.http.ResponseEntity;

import com.yusuf.WorkOutNutritionService.dto.UserDataDto;

public interface IWorkoutNutritionController {
	
	public ResponseEntity<Boolean> setExerciseAndNutrition(UserDataDto userdata);
	
	public ResponseEntity<Boolean> deleteExerciseAndNutrition(Long userId);

}
