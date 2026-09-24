package com.yusuf.UserService.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.yusuf.UserService.enums.FitnessGoal;
import com.yusuf.UserService.enums.Gender;
import com.yusuf.UserService.enums.MuscleGroup;

import jakarta.persistence.ElementCollection;
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

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String lastName;
	
	private LocalDate birthDate;	
	
	private String email;
	
	private String password;
	
	@Enumerated(EnumType.STRING) // Veritabanına 0,1 yerine direkt "MALE" yazması için en iyi pratiktir.
	private Gender gender;
	
	private Double height;
	
	private Double weight;
	
	@Enumerated(EnumType.STRING)
	private FitnessGoal fitnessGoal;
	
	@ElementCollection(targetClass = MuscleGroup.class) //Basit yapıların listesini tutmak için kullanılır. Ayrı tablo oluşturur.
	@Enumerated(EnumType.STRING)
	private List<MuscleGroup> targetMuscleGroup;
	
	private int dailyAvaliableTime;
	
	private LocalDateTime createTime;
}
