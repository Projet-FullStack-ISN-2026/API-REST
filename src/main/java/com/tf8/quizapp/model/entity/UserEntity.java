package com.tf8.quizapp.model.entity;

import jakarta.persistence.*;
import java.util.List;

/**
 * @author DIENE Serigne Fallou
 */

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 50)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false, length = 20)
	private String lastname;

	@Column(nullable = false, length = 20)
	private String firstname;

	/**
	 * User roles Player : 0 Host : 1 Admin : 2
	 */
	@Column(nullable = false)
	private int role;
	/**
	 * The user can chose mupltiple choises MappedBy indicates that the Foreign Key
	 * belongs to ChooseEntity
	 */
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<ChooseEntity> choices;

	/**
	 * Constructor without parameters
	 */
	public UserEntity() {
	}
	// Getters et Setters
	/**
	 * Getter of the ID
	 * @return ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Setter of the ID
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Getter of the user's email
	 * @return the user's email 
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Setter of the user's email
	 * @param email the user's email 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Getter of the user's password
	 * @return the user's password 
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Setter of the user's password
	 * @param  password the user's password 
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Getter of the user's LastName
	 * @return the user's LastName 
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * Setter of the user's LastName
	 * @param LastName the user's LastName 
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * Getter of the user's FisrtName
	 * @return the user's FirstName 
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * Setter of the user's FirstName
	 * @param FisrtName the user's FirstName 
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * Getter of the user's role
	 * @return the user's role 
	 */
	public int getRole() {
		return role;
	}
	/**
	 * Setter of the user's role
	 * @param the user's role 
	 */
	public void setRole(int role) {
		this.role = role;
	}
	/**
	 * Getter of the user's choices
	 * @return the user's choices 
	 */
	public List<ChooseEntity> getChoices() {
		return choices;
	}
	/**
	 * Setter of the user's choices
	 * @return the user's choices 
	 */
	public void setChoices(List<ChooseEntity> choices) {
		this.choices = choices;
	}
}
