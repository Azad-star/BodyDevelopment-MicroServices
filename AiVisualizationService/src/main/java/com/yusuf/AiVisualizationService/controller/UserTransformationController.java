package com.yusuf.AiVisualizationService.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yusuf.AiVisualizationService.controller.interfaces.IUserTransformationController;
import com.yusuf.AiVisualizationService.dto.AiTransformationRequestDto;
import com.yusuf.AiVisualizationService.dto.AiTransformationResponseDto;
import com.yusuf.AiVisualizationService.service.interfaces.IUserTransformationService;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@RequestMapping("rest-api/ai-visualization")
public class UserTransformationController implements IUserTransformationController {

	private final IUserTransformationService service; 
	
	@Override
	@PostMapping(value = "/generate", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> generateImage(Long userId, MultipartFile currentPhoto) {
		
		try {
			AiTransformationRequestDto request = new AiTransformationRequestDto();
			request.setUserId(userId);
			request.setCurrentPhoto(currentPhoto);
			AiTransformationResponseDto response = service.generateImage(request);
			return ResponseEntity.ok(response);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body("İşlem başarısız: " + e.getMessage());
		}
	}
	
	@GetMapping("/get-prompt")
	public ResponseEntity<String> getUserPrompt (@RequestParam("userId") Long userId) throws Exception {
		return ResponseEntity.ok(service.getUserPrompt(userId));
	}
	
	@DeleteMapping("/delete")
	@Override
	public ResponseEntity<Boolean> deleteImage(@RequestParam("userId") Long userId) {
		return ResponseEntity.ok(service.deleteImage(userId));
	}

}
