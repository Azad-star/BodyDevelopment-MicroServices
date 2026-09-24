package com.yusuf.MealService.dto;

import java.util.List;

import com.yusuf.MealService.enums.FitnessGoal;
import com.yusuf.MealService.enums.MealStyle;
import com.yusuf.MealService.enums.ProteinType;

import lombok.Data;

@Data
public class UserMealRequestDto {
	
	private Long userId;
	
	private List<ProteinType> proteinType;
	
	private List<MealStyle>mealStyle;

}
