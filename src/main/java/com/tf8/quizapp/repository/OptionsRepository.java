package com.tf8.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.tf8.quizapp.model.dto.OptionsDTO;
import com.tf8.quizapp.model.entity.OptionsEntity;
 
/**
 * @author imane
 */
@Repository
public interface OptionsRepository  extends JpaRepository<OptionsEntity, Long> {
 
}