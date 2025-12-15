package com.tf8.quizapp.model.dto;

/**
 * @author imane
 */
public class OptionsDTO {

	private Long id;
	private String text;
	
	//A rajouter dans la DTO
	private boolean isCorrect;

	/**
	 * Constructor without parameters
	 */
	public OptionsDTO() {
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
	 * Getter of the option's id
	 * @return the option's id
	 */
	public Long getId() {
		return id;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}