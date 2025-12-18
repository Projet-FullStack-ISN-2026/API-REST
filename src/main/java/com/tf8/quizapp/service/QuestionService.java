package com.tf8.quizapp.service;

import java.util.List;

import com.tf8.quizapp.model.dto.QuestionDTO;

public interface QuestionService {
	
	
	 // Créer une question
    QuestionDTO createQuestion(QuestionDTO questionDTO);

    // Récupérer toutes les questions
    List<QuestionDTO> getAllQuestions();
    
    //Récupérer une seule question
    QuestionDTO getQuestion(Long id);

	
}
