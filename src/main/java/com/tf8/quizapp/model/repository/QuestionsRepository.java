package com.tf8.quizapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tf8.quizapp.model.dto.QuestionDTO;

public interface QuestionsRepository  extends JpaRepository<QuestionDTO, Long> {

}
