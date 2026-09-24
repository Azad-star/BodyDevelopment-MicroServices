package com.yusuf.AiVisualizationService.service.interfaces;

import com.yusuf.AiVisualizationService.dto.AiTransformationRequestDto;
import com.yusuf.AiVisualizationService.dto.AiTransformationResponseDto;

public interface IUserTransformationService {
	
	public AiTransformationResponseDto generateImage(AiTransformationRequestDto request)throws Exception;
	
	public String getUserPrompt(Long userId) throws Exception; 
	
	public Boolean deleteImage(Long userId);
}
