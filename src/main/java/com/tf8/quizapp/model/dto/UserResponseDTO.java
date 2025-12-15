package com.tf8.quizapp.model.dto;
 
import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.NotBlank;
 
/**
* @author DIENE Serigne Fallou
*/

public class UserResponseDTO {
 
	private Long id;
	private String email;
	private String password;
	private String lastName;
	private String firstName;
	private int role;

	// Getters and Setters 
	/**
	 * Getter of the user's ID
	 * @return User's ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter of the user's ID
	 * @param id User's ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter of the user's email 
	 * @return User's email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter of the user's email 
	 * @param email User's email 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter of the user's password
	 * @return User's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter of the user's password
	 * @param password User's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter of the user's Last name
	 * @return User's Last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter of the user's Last name
	 * @param lastName User's Last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Getter of the user's first name
	 * @return user's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter of user's first name
	 * @param firstName user's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter of user's role
	 * @return user's role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * Setter of user's role
	 * @param role user's role
	 */
	public void setRole(int role) {
		this.role = role;
	}
}
 