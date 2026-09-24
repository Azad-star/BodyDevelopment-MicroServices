package com.yusuf.UserService.contoller.interfaces;

import org.springframework.http.ResponseEntity;

import com.yusuf.UserService.dto.UserAuthDto;
import com.yusuf.UserService.dto.UserDataDto;
import com.yusuf.UserService.entity.User;
import com.yusuf.UserService.enums.FitnessGoal;

public interface IUserController {
	
	public ResponseEntity<Boolean> saveUser(User user);
	public ResponseEntity<UserDataDto> getUser(Long userId);
	public ResponseEntity<FitnessGoal> getUserFitnessGoal(Long userId);
	public ResponseEntity<Boolean> deleteUser(Long userId);
	public ResponseEntity<UserAuthDto> getUserForAuth(String email);
}
