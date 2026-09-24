package com.yusuf.AiVisualizationService.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AiTransformationRequestDto {

	private Long userId;
	
	private MultipartFile currentPhoto;
}
