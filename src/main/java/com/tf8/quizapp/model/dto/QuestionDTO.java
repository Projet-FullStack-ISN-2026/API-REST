package com.tf8.quizapp.model.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotNull;

/**
 * @author imane
 */
public class QuestionDTO {
	
	@NotNull(message = "Question's ID is required")
	private Long id;
	@NotNull(message = "The question content is required")
	private String question;
	private List<OptionsDTO> options = new ArrayList<>();

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
	/**
	 * Setter of the option's id
	 * @param id the option's id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	public ArrayList<OptionsDTO> getOptions() {
	    return new ArrayList<>(this.options);
	}

	public void setOptions(List<OptionsDTO> options) {
	    if (options == null) {
	        this.options = new ArrayList<>();
	    } else {
	        this.options = new ArrayList<>(options);
	    }
	}

}
