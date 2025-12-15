package com.tf8.quizapp.model.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * @author imane
 */
public class OptionsDTO {
	
	@NotBlank(message = "Option's ID is required")
	private Long id;
	@NotBlank(message = "Option's content is required")
	private String text;
	@NotBlank(message = "Boolean attribute is required")
	private boolean isCorrect;

	/**
	 * Constructor without parameters
	 */
	public OptionsDTO() {
	}

	/**
	 * Getter of the option's id
	 * @return the option's id
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
	/**
	 * Getter of the option's content
	 * @return the content of the option
	 */
	public String getText() {
		return text;
	}

	/**
	 * Setter of the option's content
	 * @param text the content of the option
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Getter of isCorrect
	 * @return true or false
	 */
	public Boolean getIsCorrect() {
		return isCorrect;
	}
	/**
	 * Setter of isCorrect
	 * @param isCorrect option's status
	 */
	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}
