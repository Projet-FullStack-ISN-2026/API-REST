package fr.esigelec.projetFullStackAPI.dto;

import jakarta.validation.constraints.NotNull;

/**
 * @author DIENE Serigne Fallou
 */

public class Choose {

	@NotNull(message = "L'ID de l'utilisateur est requis")
	private Long idUtilisateur;

	@NotNull(message = "L'ID de l'option choisie est requis")
	private Long idOption;

	// Getters et Setters
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