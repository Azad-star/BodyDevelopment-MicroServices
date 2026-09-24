package com.yusuf.WorkOutNutritionService.entity;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercise")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String exerciseName;
	
	@Column(nullable = false)
	private String targetMuscleGroup;
	
	private Integer sets;
	
	private Integer reps;
	
	private String description;
	

}
