package fr.esigelec.projetFullStackAPI.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * @author DIENE Serigne Fallou
 */

/**
 *  Classe DTO pour la connexion
 */

public class UtilisateurLoginDto {

	@NotBlank(message = "L'email est requis")
	@Email(message = "Format d'email invalide")
	private String email;

	@NotBlank(message = "Le mot de passe est requis")
	private String password;

	// Getters et Setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}