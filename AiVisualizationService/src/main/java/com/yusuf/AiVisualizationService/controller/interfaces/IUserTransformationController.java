package com.yusuf.AiVisualizationService.controller.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IUserTransformationController {
	
	public ResponseEntity<?> generateImage(Long userId, MultipartFile currentPhoto);
	
	public ResponseEntity<String> getUserPrompt(Long userId) throws Exception; 
	
	public ResponseEntity<Boolean> deleteImage(Long userId);
}
