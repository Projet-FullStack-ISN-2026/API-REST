package com.tf8.quizapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tf8.quizapp.model.dto.QuestionDTO;

@Repository
public interface QuestionsRepository  extends JpaRepository<QuestionDTO, Long> {

}
