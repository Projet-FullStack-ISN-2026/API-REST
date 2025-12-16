package com.tf8.quizapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tf8.quizapp.model.dto.QuestionDTO;
import com.tf8.quizapp.model.dto.QuizDTO;
import com.tf8.quizapp.model.dto.QuizDetailDTO;
import com.tf8.quizapp.model.entity.ChooseEntity;
import com.tf8.quizapp.model.entity.QuizEntity;

import com.tf8.quizapp.service.impl.QuizServiceImpl;


/**
 * @author 56036494 SEWANOU OZA
 */

@RestController
@RequestMapping("/quiz")
public class QuizApiController {
	
	private QuizServiceImpl quizService;
	
	public QuizApiController(QuizServiceImpl quizService) {
        this.quizService = quizService;
    }
	
	@GetMapping()
	public List<QuizDTO> quizGet() {
		return quizService.quizGet();
	}
	
	@GetMapping()
	@RequestMapping("/{id}/questions") 
	public List<QuestionDTO> quizGetQuestions(@PathVariable Long id) {
		return (List<QuestionDTO>) quizService.quizQuizIdQuestionsGet(id);
	}
	
	@GetMapping()
	@RequestMapping("/{id}") 
	public QuizDetailDTO quizGetDetails(@PathVariable Long id) {
		return (QuizDetailDTO) quizService.quizQuizIdGetDetail(id);
	}
	
	@RequestMapping("/{id}/control/start") 
	@PostMapping()
	public QuizDTO quizStart(@PathVariable Long id) {
		return quizService.quizStart(id);
	}
	
	@RequestMapping("/{id}/control/finish") 
	@PostMapping()
	public QuizDTO quizFinish(@PathVariable Long id) {
		return quizService.quizFinish(id);
	}
	
	@PostMapping()
	public QuizEntity quizPost(@RequestBody QuizEntity body) {
		return quizService.quizPost(body);
	}
	
	
    
	@RequestMapping("/{quizId}/play/current-question") 
    @GetMapping()
    public QuestionDTO currentQuestion(@PathVariable Long quizId) {
    	return quizService.getCurrentQuestion(quizId);
    }
    
	@RequestMapping("/{quizId}/play/next-question") 
    @GetMapping("/quiz/{quizId}/play/next-question")
    public QuestionDTO nextQuestion(@PathVariable Long quizId) {
    	return quizService.getNextQuestion(quizId);
    }
    /*
	@RequestMapping("/{quizId}/play/leaderboard") 
    @GetMapping()
    public List<ClassementDTO> getClassement(@PathVariable Long quizId) {
    	return quizService.getClassement(quizId);
    }
	@RequestMapping("/{quizId}/user/{userId}/option/{optionId}/answer") 
	@PostMapping()
    public ChooseEntity answerQuiz(
        @PathVariable Long quizId,
        @PathVariable Long userId,
        @PathVariable Long optionId
    ) {
        return quizService.saveAnswer(quizId, userId, optionId);
    }*/
	
	
}