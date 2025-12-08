package com.tf8.quizapp.model.dto;
 
import jakarta.validation.constraints.NotNull;
 
/**
* @author DIENE Serigne Fallou
*/
 
public class ChooseDTO {
 
	@NotNull(message = "User ID is required")
	private Long idUtilisateur;
 
	@NotNull(message = "The ID of the selected option is required")
	private Long idOption;
 
	// Getters and Setters
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
 
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
 
	public Long getIdOption() {
		return idOption;
	}
 
	public void setIdOption(Long idOption) {
		this.idOption = idOption;
	}
}