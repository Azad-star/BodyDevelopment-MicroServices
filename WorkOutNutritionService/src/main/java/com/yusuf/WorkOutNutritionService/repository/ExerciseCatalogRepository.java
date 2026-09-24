package com.yusuf.WorkOutNutritionService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yusuf.WorkOutNutritionService.entity.ExerciseCatalog;

@Repository
public interface ExerciseCatalogRepository extends JpaRepository<ExerciseCatalog, Long>{

	 List<ExerciseCatalog> findAllByTargetMuscleGroupIn(List<String> taregetMuscleGroup);
}
