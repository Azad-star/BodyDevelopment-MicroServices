package com.yusuf.MealService.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table( name = "user_meal_plan")
public class UserMealPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private Long userId;
	
	@ManyToMany
	@JoinTable(
		name = "user_meal_plan_details",
		joinColumns = @JoinColumn(name = "plan_id"),
		inverseJoinColumns = @JoinColumn(name = "meal_id")
			)
	private List<MealCatalog> meals;

}
