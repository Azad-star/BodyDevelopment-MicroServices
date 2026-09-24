package com.yusuf.AiVisualizationService.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_transformation")
public class UserTransformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long userId;
	
	@Column(unique = true, nullable = false)
	private String originalImageUrl;
	
	@Column(unique = true, nullable = false)
	private String generatedImageUrl;
	
	private LocalDateTime createTime = LocalDateTime.now();

}
