package com.yusuf.WorkOutNutritionService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yusuf.WorkOutNutritionService.entity.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

}
