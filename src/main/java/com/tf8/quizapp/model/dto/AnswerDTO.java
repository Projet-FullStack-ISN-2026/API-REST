package com.tf8.quizapp.model.dto;

public class AnswerDTO {
	
	private Long questionId;
	
	private Long correctOptionId;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getCorrectOptionId() {
		return correctOptionId;
	}

	public void setCorrectOptionId(Long correctOptionId) {
		this.correctOptionId = correctOptionId;
	}
	
	

}
