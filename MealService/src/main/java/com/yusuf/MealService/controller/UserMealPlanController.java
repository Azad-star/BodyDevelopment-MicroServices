package com.yusuf.MealService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yusuf.MealService.controller.interfaces.IUserMealPlanController;
import com.yusuf.MealService.dto.UserMealRequestDto;
import com.yusuf.MealService.entity.UserMealPlan;
import com.yusuf.MealService.service.interfaces.IUserMealPlanService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest-api/userMealPlan")
public class UserMealPlanController implements IUserMealPlanController {

	private final IUserMealPlanService mealPlanService;
	
	@PostMapping("/create")
	@Override
	public ResponseEntity<UserMealPlan> setUserMealPlan(@RequestBody UserMealRequestDto mealRequest) throws Exception {
		return ResponseEntity.ok(mealPlanService.setUserMealPlan(mealRequest));
	}
	
	@DeleteMapping("/delete")
	@Override
	public ResponseEntity<Boolean> deleteUserMealPlan(@RequestParam("userId") Long userId) {
		return ResponseEntity.ok(mealPlanService.deleteUserMealPlan(userId));
	}

}
