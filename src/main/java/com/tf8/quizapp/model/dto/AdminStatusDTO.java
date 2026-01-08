package com.tf8.quizapp.model.dto;

/**
 * @author CHINCOUN Loan
 */

public class AdminStatusDTO {

	private Long quizId;
	private QuizDTO quiz;
	public Long getQuizId() {
		return quizId;
	}
	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}
	public QuizDTO getQuiz() {
		return quiz;
	}
	public void setQuiz(QuizDTO quiz) {
		this.quiz = quiz;
	}
	
}
