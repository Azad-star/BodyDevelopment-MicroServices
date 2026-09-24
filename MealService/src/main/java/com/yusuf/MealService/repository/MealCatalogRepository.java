package com.yusuf.MealService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yusuf.MealService.entity.MealCatalog;
import com.yusuf.MealService.enums.FitnessGoal;
import com.yusuf.MealService.enums.MealStyle;
import com.yusuf.MealService.enums.ProteinType;

@Repository
public interface MealCatalogRepository extends JpaRepository<MealCatalog, Long> {
    
    List<MealCatalog> findAllByFitnessGoalAndProteinTypeInAndMealStyleIn(
            FitnessGoal fitnessGoal, 
            List<ProteinType> proteinType, 
            List<MealStyle> mealStyle );
   
}