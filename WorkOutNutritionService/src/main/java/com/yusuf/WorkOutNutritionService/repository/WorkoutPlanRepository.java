package com.yusuf.WorkOutNutritionService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yusuf.WorkOutNutritionService.entity.WorkoutPlan;

@Repository
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long>{
	
	Boolean existsByUserId(Long userId);
	
	@Transactional
	void deleteByUserId(Long userId);
}
