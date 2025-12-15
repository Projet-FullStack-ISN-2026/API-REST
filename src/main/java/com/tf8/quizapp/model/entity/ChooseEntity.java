package com.tf8.quizapp.model.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

/**
 * @author DIENE Serigne Fallou
 */
@Entity
@Table(name = "choose")
public class ChooseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Timestamp date;

	// Link to User
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntity user;

	// Link to Options
	@ManyToOne
	@JoinColumn(name = "options_id", nullable = false)
	private OptionsEntity option;

	// Link to Quiz
	@ManyToOne
	@JoinColumn(name = "quiz_id", nullable = false)
	private QuizEntity quiz;

	/**
	 * Constructor without parameters
	 */
	public ChooseEntity() {

	}
	/**
	 * Getter of the choice's ID
	 * @return ID the choice's ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Setter of the choice's ID
	 * @param ID the choice's ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Getter of the choice's date
	 * @return date the choice's date
	 */
	public Timestamp getDate() {
		return date;
	}
	/**
	 * Setter of the choice's date
	 * @param date the choice's date
	 */
	public void setDate(Timestamp date) {
		this.date = date;
	}
	/**
	 * Getter of the user object
	 * @return USER the user that made the choice
	 */
	public UserEntity getUser() {
		return user;
	}
	/**
	 * Setter of the USER the user that made the choice
	 * @param UserEntity the user that made the choice
	 */
	public void setUser(UserEntity user) {
		this.user = user;
	}
	/**
	 * Getter of the Option object chosen 
	 * @return Option
	 */
	public OptionsEntity getOption() {
		return option;
	}
	/**
	 * Setter of the Option object chosen by the user
	 * @param OptionEntity the option chosen by the user
	 */
	public void setOption(OptionsEntity option) {
		this.option = option;
	}
	/**
	 * Getter of the QuizEntity 
	 * @return QuizEntity that the player are in
	 */
	public QuizEntity getQuiz() {
		return quiz;
	}
	/**
	 * Setter of the Quiz object
	 * @param QuizEntity that the player are in
	 */
	public void setQuiz(QuizEntity quiz) {
		this.quiz = quiz;
	}
}
