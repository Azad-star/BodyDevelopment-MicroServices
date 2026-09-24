package com.yusuf.AiVisualizationService.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AiTransformationResponseDto {
	
	private Long userId;
	
	private String originalImageUrl;
	
	private String generatedImageUrl;

}
