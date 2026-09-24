package com.yusuf.WorkOutNutritionService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yusuf.WorkOutNutritionService.entity.DailyMacroGoal;

@Repository
public interface DailyMacroGoalRepository extends JpaRepository<DailyMacroGoal, Long>{
	
	@Transactional
	void deleteByUserId(Long userId);
}
