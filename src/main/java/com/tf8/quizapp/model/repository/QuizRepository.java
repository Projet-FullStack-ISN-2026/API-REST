package com.tf8.quizapp.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tf8.quizapp.model.dto.QuizDTO;

public interface QuizRepository extends  JpaRepository<QuizDTO, Long> {
	
	List<QuizDTO> findByStatus(int status);
    List<QuizDTO> findByTitleContaining(String title);
}
