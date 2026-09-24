package com.yusuf.WorkOutNutritionService.service.interfaces;

import com.yusuf.WorkOutNutritionService.dto.UserDataDto;

public interface IWorkoutNutritionService {
	
	public Boolean setExerciseAndNutrition(UserDataDto userData); 
	
	public Boolean deleteExerciseAndNutrition(Long userId);

}
