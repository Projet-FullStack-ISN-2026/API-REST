package com.tf8.quizapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tf8.quizapp.model.dto.QuestionDTO;
import com.tf8.quizapp.model.dto.UserResponseDTO;
import com.tf8.quizapp.service.QuestionService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tf8.quizapp.model.dto.QuestionDTO;
import com.tf8.quizapp.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions") // Définit l'URL de base pour ce contrôleur
public class QuestionsApiController {

    private final QuestionService questionService;

    // Injection du service
    public QuestionsApiController(QuestionService questionService) {
        this.questionService = questionService;
    }

    /**
     * GET /questions : Récupère la liste de toutes les questions
     */
    @GetMapping
    public ResponseEntity<List<QuestionDTO>> getAllQuestions() {
        List<QuestionDTO> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    /**
     * POST /questions : Crée une nouvelle question
     */
    @PostMapping
    public ResponseEntity<QuestionDTO> createQuestion(@Valid @RequestBody QuestionDTO questionDTO) {
        QuestionDTO createdQuestion = questionService.createQuestion(questionDTO);
        return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
    }
    
    @GetMapping
    @RequestMapping("/{id}") 
    public ResponseEntity<QuestionDTO> questionsQuestionIdGet( @PathVariable  Long id) {
    		        
    	QuestionDTO response = questionService.getQuestion(id); 
		return new ResponseEntity<QuestionDTO>(response, HttpStatus.OK);            
        
    }

}
