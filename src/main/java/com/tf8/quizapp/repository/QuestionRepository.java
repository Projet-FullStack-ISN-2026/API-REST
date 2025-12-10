package com.tf8.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.tf8.quizapp.model.dto.QuestionDTO;
import com.tf8.quizapp.model.entity.QuestionEntity;
 
/**
 * @author imane
 */
@Repository
public interface QuestionRepository  extends JpaRepository<QuestionEntity, Long> {
 
}
