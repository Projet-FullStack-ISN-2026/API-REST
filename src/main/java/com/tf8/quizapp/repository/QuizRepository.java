package com.tf8.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tf8.quizapp.model.entity.QuizEntity;

public interface QuizRepository extends JpaRepository<QuizEntity, Long> {

}
