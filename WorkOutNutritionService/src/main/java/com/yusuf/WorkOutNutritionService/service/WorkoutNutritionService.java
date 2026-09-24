package com.yusuf.WorkOutNutritionService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.yusuf.WorkOutNutritionService.dto.UserDataDto;
import com.yusuf.WorkOutNutritionService.entity.DailyMacroGoal;
import com.yusuf.WorkOutNutritionService.entity.Exercise;
import com.yusuf.WorkOutNutritionService.entity.ExerciseCatalog;
import com.yusuf.WorkOutNutritionService.entity.WorkoutPlan;
import com.yusuf.WorkOutNutritionService.entity.WorkoutSession;
import com.yusuf.WorkOutNutritionService.repository.DailyMacroGoalRepository;
import com.yusuf.WorkOutNutritionService.repository.ExerciseCatalogRepository;
import com.yusuf.WorkOutNutritionService.repository.WorkoutPlanRepository;
import com.yusuf.WorkOutNutritionService.repository.WorkoutSessionRepository;
import com.yusuf.WorkOutNutritionService.service.interfaces.IWorkoutNutritionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkoutNutritionService implements IWorkoutNutritionService {
	
	private final DailyMacroGoalRepository macroGoalRepository;
	private final ExerciseCatalogRepository exerciseCatalogRepository;
	private final WorkoutPlanRepository workoutPlanRepository;
	private final WorkoutSessionRepository workoutSessionrepository;
	
	public DailyMacroGoal calculateDailyMacro(UserDataDto userData) {
		
			DailyMacroGoal macroGoal = new DailyMacroGoal();

			Long userId = userData.getUserId();
			double weight = userData.getWeight();
			double height = userData.getHeight();
			int age = userData.getAge();
			String gender = userData.getGender();
			String fitnessGoal = userData.getFitnessGoal();
			
			double targetCalories = 0;
			double targetProtein = 0;
			double targetCarbs = 0;
			double targetFats = 0; 
			
			double bmr = 0;
			
			if(gender.equals("ERKEK")) bmr = (10 * weight) + (6.25 * height) - (5 * age) + (5) ;
			else bmr = (10 * weight) + (6.25 * height) - (5 * age) - (161) ;
			
			double tdee = (bmr * 1.55);
			
			if(fitnessGoal.equals("FIT_KALMA")) {
				
				targetCalories = tdee;
				targetProtein = (weight * 1.8);
				targetFats = ((targetCalories * 0.30) / 9);
				targetCarbs = ((targetCalories - (4 * targetProtein) - (9 * targetFats)) / 4);
				
			}
			else if(fitnessGoal.equals("KILO_VERME")) {
				
				targetCalories = (tdee - 500);
				targetProtein = (weight * 2.4);
				targetFats = ((targetCalories * 0.30) / 9);
				targetCarbs = ((targetCalories - (4 * targetProtein) - (9 * targetFats)) / 4);
			}
			else if(fitnessGoal.equals("KAS_KAZANIMI")) {
				
				targetCalories = (tdee + 500);
				targetProtein = (weight * 2.2);
				targetFats = ((targetCalories * 0.25) / 9);
				targetCarbs = ((targetCalories - (4 * targetProtein) - (9 * targetFats)) / 4);
			}
			
			macroGoal.setUserId(userId);
			macroGoal.setTargetCalories(targetCalories);
			macroGoal.setTargetCarbs(targetCarbs);
			macroGoal.setTargetFats(targetFats);
			macroGoal.setTargetProtein(targetProtein);

			return macroGoal;
	}
	
	public Exercise setExercise(UserDataDto userData) {
		
			Exercise exercise = new Exercise();
			ExerciseCatalog exerciseCatalog = new ExerciseCatalog();
			
			String fitnessGoal = userData.getFitnessGoal();
			List<String> targetMuscleGroup = userData.getTargetMuscleGroup();
			
			List<ExerciseCatalog> mappedExercise = exerciseCatalogRepository.findAllByTargetMuscleGroupIn(targetMuscleGroup); 
			exerciseCatalog = mappedExercise.get(new Random().nextInt(mappedExercise.size()));
			
			if(fitnessGoal.equals("KAS_KAZANIMI")) {
				exercise.setExerciseName(exerciseCatalog.getName());
				exercise.setTargetMuscleGroup(exerciseCatalog.getTargetMuscleGroup());
				exercise.setSets(4);
				exercise.setReps(10);
				exercise.setDescription(exerciseCatalog.getDescription());
				
			}else if(fitnessGoal.equals("KILO_VERME")) {
				exercise.setExerciseName(exerciseCatalog.getName());
				exercise.setTargetMuscleGroup(exerciseCatalog.getTargetMuscleGroup());
				exercise.setSets(3);
				exercise.setReps(15);
				exercise.setDescription(exerciseCatalog.getDescription());
				
			}else if(fitnessGoal.equals("FIT_KALMA")) {
				exercise.setExerciseName(exerciseCatalog.getName());
				exercise.setTargetMuscleGroup(exerciseCatalog.getTargetMuscleGroup());
				exercise.setSets(3);
				exercise.setReps(10);
				exercise.setDescription(exerciseCatalog.getDescription());
			}
	
			return exercise;
	}
	
	
	
	public WorkoutSession setWorkoutSession(UserDataDto userData, int day) {
		
			int dayOfExercise = day;
			WorkoutSession workoutSession = new WorkoutSession();
			
			List<Exercise> exerciseList = new ArrayList<>();
			List<String> targetMuscleGroupList = new ArrayList<>();
			Exercise exercise = new Exercise();
			
			int dailyAvailabletime = userData.getDailyAvaliableTime();
			int dailyTotalExercise = (dailyAvailabletime/10);
			
			//Dinlenme Günü Ayarlama
			if(dailyAvailabletime == 90 || dailyAvailabletime == 120 ) {
				if(dayOfExercise%3==0) {
					workoutSession.setIsRestDay(true);
				}else {
					workoutSession.setIsRestDay(false);
				}
			}else if( dailyAvailabletime == 60) {
				if(dayOfExercise%4==0) {
					workoutSession.setIsRestDay(true);
				}else {
					workoutSession.setIsRestDay(false);
				}
			}else if( dailyAvailabletime == 30 || dailyAvailabletime == 45 ) {
					workoutSession.setIsRestDay(false);
			}
			
			
			//Egzersiz Günü Yapılacaklar
			if(workoutSession.getIsRestDay() == false) {
				
				//Exercise atama
				int count = 0;
				while(count!=dailyTotalExercise) {	
					exercise = setExercise(userData);
					if(exercise == null) {
						break;
					}else if(!exerciseList.contains(exercise)) {						
						exerciseList.add(exercise);
						count++;
					}
					
				}
				
				//Atanan Exercise ın muscleGrop unu alma
				for(Exercise ex : exerciseList) {
					String muscleGroup = ex.getTargetMuscleGroup();
					if(!targetMuscleGroupList.contains(muscleGroup)) targetMuscleGroupList.add(muscleGroup);	
				}
				
				
				workoutSession.setSessionName(dayOfExercise + ". Gün  Egzersiz : " + String.join(", ", targetMuscleGroupList));
			}else {
				
				workoutSession.setSessionName(dayOfExercise + ". Gün  Dinlenme : ");

			}
			
			workoutSession.setDayNumber(dayOfExercise);
			workoutSession.setExercises(exerciseList);
		
			return workoutSession;
	}
	
	public WorkoutPlan setWorkoutPlan(UserDataDto userData) {
		
			WorkoutPlan workoutPlan = new WorkoutPlan();
			
			int day = 1;
			WorkoutSession workoutSession = new WorkoutSession();
			
			List<WorkoutSession> workoutSessionList = new ArrayList<>();

			Long userId = userData.getUserId();
			String gender = userData.getGender();
			String fitnessGoal = userData.getFitnessGoal();
			
			workoutPlan.setUserId(userId);
			workoutPlan.setFitnessGoal(fitnessGoal);
			if(gender.equals("ERKEK")) {
				workoutPlan.setPlanName((gender + "'LER İÇİN " + fitnessGoal));
			}else {
				workoutPlan.setPlanName((gender + "'LAR İÇİN " + fitnessGoal));
			}
			for(int i = 0 ; i < 30 ; i++) {
				workoutSession = setWorkoutSession(userData, day);
				day++;
				workoutSessionList.add(workoutSession);
				workoutSession.setWorkoutPlan(workoutPlan);
				
			}
			
			workoutPlan.setSessions(workoutSessionList);
			
			return workoutPlan;
	}
	
	
	@Override
	@Transactional
	public Boolean setExerciseAndNutrition(UserDataDto userData) {
		
		try {
			
			DailyMacroGoal macroGoal = calculateDailyMacro(userData);
			WorkoutPlan workoutPlan = setWorkoutPlan(userData);
			macroGoalRepository.save(macroGoal);
			workoutPlanRepository.save(workoutPlan);
			
			return true;
			
		} catch (Exception e) {
			
			System.out.println("EROR in setExerciseAndNutrition method  ==>> " + e.getMessage());
			e.printStackTrace(); // Hatayı konsolda detaylıca görmek için bunu eklemek her zaman iyidir.
			
			return false;
		}
		
		
	}

	@Override
	public Boolean deleteExerciseAndNutrition(Long userId) {
		
		if(workoutPlanRepository.existsByUserId(userId)) 
		{
			workoutPlanRepository.deleteByUserId(userId);
			macroGoalRepository.deleteByUserId(userId);
			return true;
		}
		return false;
	}

}
