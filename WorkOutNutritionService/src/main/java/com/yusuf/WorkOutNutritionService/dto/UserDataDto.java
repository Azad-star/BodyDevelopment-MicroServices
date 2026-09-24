package com.yusuf.WorkOutNutritionService.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDataDto {
	
	private Long userId;
	
	private Double weight;
	
	private Double height;
	
	private Integer age;
	
	private String gender;
	
	private String fitnessGoal;
	
	private List<String> targetMuscleGroup;
	
	private int dailyAvaliableTime;


}
