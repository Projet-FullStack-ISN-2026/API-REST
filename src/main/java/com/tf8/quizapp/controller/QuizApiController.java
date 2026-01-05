package com.tf8.quizapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;

import com.tf8.quizapp.model.dto.AnswerDTO;
import com.tf8.quizapp.model.dto.ChooseDTO;
import com.tf8.quizapp.model.dto.ClassementDTO;
import com.tf8.quizapp.model.dto.PlayerAnswerDTO;
import com.tf8.quizapp.model.dto.QuestionDTO;
import com.tf8.quizapp.model.dto.QuestionLinkDTO;
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
	
	@PostMapping()
	public QuizDetailDTO quizPost(@RequestBody QuizEntity body) {
		return quizService.quizPost(body);
	}
	
	@GetMapping("/{id}/questions")
	public List<QuestionDTO> quizGetQuestions(@PathVariable Long id) {
		return (List<QuestionDTO>) quizService.quizQuizIdQuestionsGet(id);
	}
	
	@PostMapping("/{id}/questions")
	public ResponseEntity quizPostQuestions(@PathVariable Long id,@RequestBody QuestionLinkDTO questionId ) {
		QuizDetailDTO response =  quizService.quizQuestionPost(id, questionId);
		return new ResponseEntity(response, HttpStatus.ACCEPTED);
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
	
	@RequestMapping("/{quizId}/play/current-question") 
    @GetMapping()
    public QuestionDTO currentQuestion(@PathVariable Long quizId) {
    	return quizService.getCurrentQuestion(quizId);
    }
    
	@RequestMapping("/{quizId}/play/next-question") 
    @GetMapping()
    public QuestionDTO nextQuestion(@PathVariable Long quizId) {
    	return quizService.getNextQuestion(quizId);
    }
	
	@RequestMapping("/{quizId}/play/answer") 
    @PostMapping()
    public ResponseEntity saveAnswer(@RequestBody PlayerAnswerDTO body, @AuthenticationPrincipal Jwt jwt) {
		//Récupération de la valeur du userId depuis le JWT décodé  
				Long userId = jwt.getClaim("userId");
				
				ChooseDTO body2 = new ChooseDTO();
				body2.setIdUser(userId);
				body2.setIdQuiz(body.getQuizId());
				body2.setIdOption(body.getOptionId());
				
				
				ChooseDTO response = quizService.saveAnswer(body2);
				return new ResponseEntity(response, HttpStatus.ACCEPTED);
    	 
    }
	
	@RequestMapping("/{quizId}/admin/answer") 
    @GetMapping()
    public AnswerDTO adminAnswer(@PathVariable Long quizId) {
		AnswerDTO response = quizService.adminAnswer(quizId);
		return quizService.adminAnswer(quizId);
    	 
    }
    
	@RequestMapping("/{quizId}/play/leaderboard") 
    @GetMapping()
    public ClassementDTO getClassement(@PathVariable Long quizId) {
    	return quizService.getClassement(quizId);
    }
	
	
	
}