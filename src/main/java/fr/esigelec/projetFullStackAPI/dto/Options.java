package fr.esigelec.projetFullStackAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @author DIENE Serigne Fallou
 */

public class Options {

	private Long id;

	@NotBlank(message = "Le texte de l'option est requis")
	private String text;

	@NotNull(message = "Il faut indiquer si cette option est la bonne réponse")
	private Boolean isCorrect;

	// Getters et Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
}