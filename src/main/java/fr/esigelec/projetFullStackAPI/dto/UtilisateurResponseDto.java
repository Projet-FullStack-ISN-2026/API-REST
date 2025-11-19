package fr.esigelec.projetFullStackAPI.dto;

/**
 * @author DIENE Serigne Fallou
 */

/**
 *  Classe DTO pour la reponse
 */

public class UtilisateurResponseDto {

	private Long id;
	private String email;
	private String lastname;
	private String firstname;
	private int role;

	// Getters et Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}