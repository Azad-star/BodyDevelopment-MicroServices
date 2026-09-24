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
@Table(name = "dailyMacroGoal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyMacroGoal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Bu hedefin hangi kullanıcıya ait olduğunu bilmeliyiz (User Service'teki ID)
    @Column(nullable = false)
    private Long userId;

    // Hedeflenen Günlük Değerler
    private double targetCalories; // Örn: 2800 kcal
    private double targetProtein;  // Örn: 160 gr (Kas inşası için kritik)
    private double targetCarbs;    // Örn: 320 gr (Enerji için)
    private double targetFats;     // Örn: 70 gr (Hormon düzeni için)

    // Kullanıcının BMI değeri veya hedefleri değiştikçe bu tablo güncellenecek
	
	

}
