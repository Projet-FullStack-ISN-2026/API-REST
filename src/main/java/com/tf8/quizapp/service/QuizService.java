package com.tf8.quizapp.service;

import com.tf8.quizapp.model.dto.QuizCreate;
import com.tf8.quizapp.model.dto.QuizDetailed;

public interface QuizService {
	
	QuizDetailed createQuiz(QuizCreate quizCreate);

}
