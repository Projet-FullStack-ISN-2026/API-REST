package fr.esigelec.projetFullStackAPI.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * @author DIENE Serigne Fallou
 */

/**
 * Classe DTO pour l'inscription On sépare le DTO en 3 pour adapter les champs
 * obligatoires à chaque action (l'inscription demande un nom, la connexion non)
 * et surtout pour garantir la sécurité en n'envoyant jamais le mot de passe
 * dans la réponse affichée au client.
 */

public class UtilisateurCreationDto {

	@NotBlank(message = "L'email ne peut pas être vide")
	@Email(message = "Format d'email invalide")
	private String email;

	@NotBlank(message = "Le mot de passe ne peut pas être vide")
	private String password;

	@NotBlank(message = "Le nom ne peut pas être vide")
	private String lastname;

	@NotBlank(message = "Le prénom ne peut pas être vide")
	private String firstname;

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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
}