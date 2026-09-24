package com.yusuf.UserService.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yusuf.UserService.contoller.interfaces.IUserController;
import com.yusuf.UserService.dto.UserAuthDto;
import com.yusuf.UserService.dto.UserDataDto;
import com.yusuf.UserService.entity.User;
import com.yusuf.UserService.enums.FitnessGoal;
import com.yusuf.UserService.service.interfaces.IUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("rest-api/user")
public class UserController implements IUserController{
	
	private final IUserService service;
	
	private ResponseEntity<Boolean> validateToken(Long userId) {
		String currentUserId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(!currentUserId.equals("internal-system") && !currentUserId.equals(String.valueOf(userId) )) {
			
			System.out.println("Access Token işlem yapılmak istenen kullanıcıya ait değil!!");
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(false);
		}
		return null;
	}
	
	private Boolean isUserExists(String email) {
		
		System.out.println("GÜVENLİK HATASI : Girilen emailde kayıtlı kullanıcı bulunmaktadır");
		return service.isUserExists(email);
	
	}
	
	@PostMapping("/save")
	@Override
	public ResponseEntity<Boolean> saveUser(@RequestBody User user) {
		// Aynı email kullanan bir kullanıcı zaten var ise
		if(isUserExists(user.getEmail())) return ResponseEntity.status(HttpStatus.CONFLICT).body(false);
		
		return ResponseEntity.ok(service.saveUser(user));
	}
	
	@GetMapping("/get")
	@Override
	public ResponseEntity<UserDataDto> getUser(@RequestParam("userId") Long userId) {
		
		ResponseEntity<Boolean> validation = validateToken(userId);
		
		if(validation != null) return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		
		return ResponseEntity.ok(service.getUser(userId));
	}
	
	@GetMapping("/get/fitness-goal")
	@Override
	public ResponseEntity<FitnessGoal> getUserFitnessGoal(@RequestParam("userId") Long userId) {
		
		ResponseEntity<Boolean> validation = validateToken(userId);
		
		if(validation != null) return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
		
		return ResponseEntity.ok(service.getUserFitnessGoal(userId));
	}
	
	@DeleteMapping("/delete")
	@Override
	public ResponseEntity<Boolean> deleteUser(@RequestParam("userId") Long userId) {
		
		ResponseEntity<Boolean> validation = validateToken(userId);
		
		if(validation != null) return validation;
		
		return ResponseEntity.ok(service.deleteUser(userId));
	}
	
	@GetMapping("/get-for-auth")
	@Override
	public ResponseEntity<UserAuthDto> getUserForAuth(@RequestParam("email") String email) {
		return ResponseEntity.ok(service.getUserForAuth(email));
	}

	
	


}
