package com.yusuf.MealService.entity;

import com.yusuf.MealService.enums.FitnessGoal;
import com.yusuf.MealService.enums.MealStyle;
import com.yusuf.MealService.enums.ProteinType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table( name = "meal_catalog")
@AllArgsConstructor
@NoArgsConstructor
public class MealCatalog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String mealName;
	
	private String description;
	
	private double totalCalories;
	
	private double totalProteins;
	
	private double totalCarbs;
	
	private double totalFats;
	
	@Enumerated(EnumType.STRING)
    private FitnessGoal fitnessGoal;
	
	@Enumerated(EnumType.STRING)
	private ProteinType proteinType;
	
	@Enumerated(EnumType.STRING)
	private MealStyle mealStyle;
	

}
