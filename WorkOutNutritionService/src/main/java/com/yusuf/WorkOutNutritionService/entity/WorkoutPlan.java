package com.yusuf.WorkOutNutritionService.entity;

import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "workoutPlan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long userId;
	
	@Column(nullable = false)
	private String planName;
	
	private String fitnessGoal;
	
	@OneToMany(mappedBy = "workoutPlan", cascade = CascadeType.ALL)
	private List<WorkoutSession> sessions;
	
	

}
