package com.yusuf.MealService.service.interfaces;

import com.yusuf.MealService.dto.UserMealRequestDto;
import com.yusuf.MealService.entity.UserMealPlan;

public interface IUserMealPlanService {
	
	public UserMealPlan setUserMealPlan(UserMealRequestDto mealRequest) throws Exception;
	public Boolean  deleteUserMealPlan(Long userId);

}
