package com.tf8.quizapp.model.dto;

import jakarta.validation.constraints.NotNull;

/**
 * @author DIENE Serigne Fallou
 */

public class ChooseDTO {
	@NotNull(message = "User ID is required")
	private Long idUser;
	@NotNull(message = "The ID of the selected option is required")
	private Long idOption;
	// modif par jason, ajout Quizd
	private Long idQuiz;
	
	public Long getIdQuiz() {
		return idQuiz;
	}

	public void setIdQuiz(Long idQuiz) {
		this.idQuiz = idQuiz;
	}

	// Getters and Setters
	/**
	 * Getter of the user's ID
	 * @return the user's ID
	 */
	public Long getIdUser() {
		return idUser;
	}

	/**
	 * Setter of the user's ID
	 * @param the user's ID
	 */
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	/**
	 * Getter of the option's content
	 * @return the content of the option
	 */
	
	public Long getIdOption() {
		return idOption;
	}

	/**
	 * Setter of the option's content
	 * @param text the content of the option
	 */
	public void setIdOption(Long idOption) {
		this.idOption = idOption;
	}
}