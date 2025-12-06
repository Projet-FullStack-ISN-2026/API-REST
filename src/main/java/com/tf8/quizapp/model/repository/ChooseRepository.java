package com.tf8.quizapp.model.repository;

import com.tf8.quizapp.model.entity.ChooseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author DIENE Serigne Fallou
 */
@Repository
public interface ChooseRepository extends JpaRepository<ChooseEntity, Long> {
	
	// Find all choices made by a specific user
    List<ChooseEntity> findByUserId(Long userId);
}