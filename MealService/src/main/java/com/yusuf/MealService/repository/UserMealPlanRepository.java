package com.yusuf.MealService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yusuf.MealService.entity.UserMealPlan;

@Repository
public interface UserMealPlanRepository extends JpaRepository<UserMealPlan, Long> {
	
	Optional<UserMealPlan> findByUserId(Long userId);
	
	Boolean existsByUserId(Long userId);
	
	@Transactional
	void deleteByUserId(Long userId);
}
