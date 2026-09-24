package com.yusuf.AiVisualizationService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yusuf.AiVisualizationService.entity.UserTransformation;

@Repository
public interface UserTransformationRepository extends JpaRepository<UserTransformation, Long> {

	Optional<UserTransformation> findByUserId(Long userId);

}
