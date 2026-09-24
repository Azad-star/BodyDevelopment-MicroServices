package com.yusuf.UserService.service.interfaces;

import com.yusuf.UserService.dto.UserAuthDto;
import com.yusuf.UserService.dto.UserDataDto;
import com.yusuf.UserService.entity.User;
import com.yusuf.UserService.enums.FitnessGoal;

public interface IUserService {
	
	public Boolean saveUser(User user);
	public UserDataDto getUser(Long userId);
	public FitnessGoal getUserFitnessGoal(Long userId);
	public Boolean deleteUser(Long userId);
	public UserAuthDto getUserForAuth(String email);
	public Boolean isUserExists(String email);

}
