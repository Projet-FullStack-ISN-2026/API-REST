package com.tf8.quizapp.model.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;

/**
 * @author imane
 */
public class QuestionDTO {
	
	//@NotNull(message = "Question's ID is required")
	private Long id;
	@NotNull(message = "The question content is required")
	private String question;
	
	//A rajouter dans la DTO
	private List<OptionsDTO> options;

	/**
	 * Constructor without parameters
	 */
	public QuestionDTO() {
	}

	/**
	 * Getter of the question
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Setter of the question
	 * @param question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * Getter of the question's ID
	 * @return the question's ID
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long  id2) {
		this.id = id2;
		
	}
	
	public List<OptionsDTO> getOptions() {
        return options;
    }
	
    public void setOptions(List<OptionsDTO> options) {
        this.options = options;
    }
}