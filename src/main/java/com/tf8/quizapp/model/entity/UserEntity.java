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

	 * Rôle de l'utilisateur : 0 : Joueur 1 : Animateur 2 : Admin

	 */

	@Column(nullable = false)

	private int role;
 
	/**

	 * Ici, un utilisateur peut effectuer plusieurs choix. 'mappedBy' indique

	 * que la clé étrangère se trouve dans l'entité Choose.

	 */

	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)

	private List<ChooseEntity> choices;
 
	public UserEntity() {

	}
 
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
 
	public int getRole() {

		return role;

	}
 
	public void setRole(int role) {

		this.role = role;

	}
 
	public List<ChooseEntity> getChoices() {

		return choices;

	}
 
	public void setChoices(List<ChooseEntity> choices) {

		this.choices = choices;

	}

}
 