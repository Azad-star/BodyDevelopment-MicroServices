package com.yusuf.UserService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yusuf.UserService.entity.User;
import com.yusuf.UserService.enums.FitnessGoal;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u.fitnessGoal FROM User u WHERE u.id = :userId")
    FitnessGoal findFitnessGoalById(@Param("userId") Long userId);
	
	Optional<User> findByEmail(String email);
	
	boolean existsByEmail(String email);
}
