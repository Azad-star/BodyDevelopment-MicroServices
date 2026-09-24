package com.yusuf.UserService.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yusuf.UserService.dto.UserAuthDto;
import com.yusuf.UserService.dto.UserDataDto;
import com.yusuf.UserService.entity.User;
import com.yusuf.UserService.enums.FitnessGoal;
import com.yusuf.UserService.feign_client_manager.AiVisualizationClientManager;
import com.yusuf.UserService.feign_client_manager.MealClientManager;
import com.yusuf.UserService.feign_client_manager.WorkoutNutritionClientManager;
import com.yusuf.UserService.repository.UserRepository;
import com.yusuf.UserService.service.interfaces.IUserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{
	
	private final UserRepository repository;
	private final WorkoutNutritionClientManager workoutNutritionClient;
	private final MealClientManager mealClient;
	private final AiVisualizationClientManager aiVisualizationClient;
	private final BCryptPasswordEncoder passwordEncoder;
	
	// Feign Client ile kullanıcıya exercise programı oluluşturuyoruz
	private Boolean setWorkoutNutritionForUser(User user) {
		
		UserDataDto userData = new UserDataDto();
		List<String> muscleGroup = new ArrayList<>();
		
		BeanUtils.copyProperties(user, userData);
		userData.setUserId(user.getId());
		userData.setAge(Period.between(user.getBirthDate(), LocalDate.now()).getYears());
		userData.setGender(user.getGender().name());
		userData.setFitnessGoal(user.getFitnessGoal().name());
		
		for(Object muscle : user.getTargetMuscleGroup()) {
			muscleGroup.add(muscle.toString());
		}
		userData.setTargetMuscleGroup(muscleGroup);
		
		ResponseEntity<Boolean> result = workoutNutritionClient.setExerciseAndNutrition(userData);
		
		return result.getBody();
	}
	
	@Transactional
	@Override
	public Boolean saveUser(User user) {
		
		Boolean result = null;
		try {
			
			String rawPassword = user.getPassword();
			String encodedPassword = passwordEncoder.encode(rawPassword); // Şifreyi hash'liyoruz
			user.setPassword(encodedPassword);
			
			user.setCreateTime(LocalDateTime.now());
			repository.save(user); 
			
			result = setWorkoutNutritionForUser(user);
			
		} catch (Exception e) {
			
			System.out.println("EROR ==>> "+ e.getMessage());
		}
		
		return result;
	}

	@Override
	public UserDataDto getUser(Long userId) {
		UserDataDto userData = new UserDataDto();
		List<String> muscleGroup = new ArrayList<>();
		User user = repository.getById(userId);
		BeanUtils.copyProperties(user, userData);
		userData.setUserId(user.getId());
		userData.setAge(Period.between(user.getBirthDate(), LocalDate.now()).getYears());
		userData.setGender(user.getGender().name());
		userData.setFitnessGoal(user.getFitnessGoal().name());
		
		for(Object muscle : user.getTargetMuscleGroup()) {
			muscleGroup.add(muscle.toString());
		}
		userData.setTargetMuscleGroup(muscleGroup);
		
		return userData;
	}

	@Override
	public FitnessGoal getUserFitnessGoal(Long userId) {
		FitnessGoal goal = repository.findFitnessGoalById(userId);
		return goal;
	}
	
	// Feign Client ile user a ait tüm veriler diğer serviceler araclığı ile siliniyor.
	@Transactional
	@Override
	public Boolean deleteUser(Long userId) {
		
		ResponseEntity<Boolean> workoutNutritionClientResult = workoutNutritionClient.deleteExerciseAndNutrition(userId);
		ResponseEntity<Boolean> mealClientResult = mealClient.deleteUserMealPlan(userId);
		ResponseEntity<Boolean> aiVisualizationClientResult = aiVisualizationClient.deleteImage(userId);
		Boolean userClientResult = false; 
		if(repository.existsById(userId)) {
			repository.deleteById(userId); 
			userClientResult = true;
		}
		
		if(workoutNutritionClientResult.getBody() == true ||
				mealClientResult.getBody() == true ||
				aiVisualizationClientResult.getBody() == true || 
				userClientResult == true) {
			return true;
		}
		
		System.err.println("Kullancı verileri silinirken herhangi bir service de silme işlemi gerçekleştirilemedi");
		
		return false;
	}

	// Auth Service için kullanıcı sorgulama methodu
	@Override
	public UserAuthDto getUserForAuth(String email) {
		User user = repository.findByEmail(email).orElseThrow(() -> new RuntimeException("Bu email ile kayıtlı kullanıcı bulunamadı!"));
		UserAuthDto userAuthDto = new UserAuthDto();
		BeanUtils.copyProperties(user, userAuthDto);
		return userAuthDto;
	}

	@Override
	public Boolean isUserExists(String email) {
		return repository.existsByEmail(email);
	}

}
