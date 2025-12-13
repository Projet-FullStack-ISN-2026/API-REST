package com.tf8.quizapp.service;

import com.tf8.quizapp.model.dto.QuestionDTO;
import java.util.List;

public interface QuestionService {
    
    // Créer une question
    QuestionDTO createQuestion(QuestionDTO questionDTO);

    // Récupérer toutes les questions
    List<QuestionDTO> getAllQuestions();
}