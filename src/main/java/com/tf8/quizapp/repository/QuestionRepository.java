package com.tf8.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tf8.quizapp.model.entity.QuestionEntity;

public interface QuestionRepository  extends JpaRepository <QuestionEntity, Long> {

}
