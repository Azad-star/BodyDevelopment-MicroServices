package com.yusuf.MealService.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yusuf.MealService.dto.UserMealRequestDto;
import com.yusuf.MealService.entity.MealCatalog;
import com.yusuf.MealService.entity.UserMealPlan;
import com.yusuf.MealService.enums.FitnessGoal;
import com.yusuf.MealService.feign_client_manager.UserClientManager;
import com.yusuf.MealService.repository.MealCatalogRepository;
import com.yusuf.MealService.repository.UserMealPlanRepository;
import com.yusuf.MealService.service.interfaces.IUserMealPlanService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserMealPlanService implements IUserMealPlanService{
	
	private final MealCatalogRepository catalogRepository;
	private final UserMealPlanRepository mealPlanRepository;
	private final UserClientManager clientManager;	
	
	//Feign client ile kullanıcının fitnessGoal ını alıyoruz
	private FitnessGoal getFitnessGoal(Long userId){
	FitnessGoal goal = 	clientManager.getUserFitnessGoal(userId).getBody();
	return goal;
	}
	
	@Override
	public UserMealPlan setUserMealPlan(UserMealRequestDto mealRequest) throws Exception {
		
		UserMealPlan userMealPlan = new UserMealPlan();
		List<MealCatalog> mealCatalogList = new ArrayList<>();
		
		// Kulanıcının zaten bir mealPlanı varsa onu sil
		Optional<UserMealPlan> existingPlan = mealPlanRepository.findByUserId(mealRequest.getUserId());
		existingPlan.ifPresent(mealPlanRepository::delete);
			
		try {
			 mealCatalogList = catalogRepository.findAllByFitnessGoalAndProteinTypeInAndMealStyleIn(
						getFitnessGoal(mealRequest.getUserId()), //User'ın fitnes goal'ını client manager ile alıyoruz.
						mealRequest.getProteinType(), 
						mealRequest.getMealStyle()
						);
		} catch (Exception e) {
			
		throw new Exception("ERROR MealCatalogdan meal çekerken hata oluştu ==>> " + e.getMessage());
			
		}
		
			if(mealCatalogList == null || mealCatalogList.isEmpty()) {
			throw new Exception("Kullanıcının zevkine ve ihtiyacına uygun yemek bulunamadı!");
		}
			
		Collections.shuffle(mealCatalogList);
		
		userMealPlan.setUserId(mealRequest.getUserId());
		userMealPlan.setMeals(mealCatalogList);
		
		
		return mealPlanRepository.save(userMealPlan);
	}

	@Override
	public Boolean deleteUserMealPlan(Long userId) {
		if(mealPlanRepository.existsByUserId(userId)) {
			mealPlanRepository.deleteByUserId(userId);
			return true;
		}
		return false;
	}

}
