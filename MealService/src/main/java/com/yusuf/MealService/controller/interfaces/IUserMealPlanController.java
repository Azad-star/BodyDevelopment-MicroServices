package com.yusuf.MealService.controller.interfaces;

import org.springframework.http.ResponseEntity;

import com.yusuf.MealService.dto.UserMealRequestDto;
import com.yusuf.MealService.entity.UserMealPlan;

public interface IUserMealPlanController {
	
	public ResponseEntity<UserMealPlan> setUserMealPlan(UserMealRequestDto mealRequest)throws Exception ;
	public ResponseEntity<Boolean> deleteUserMealPlan(Long userId);

}
