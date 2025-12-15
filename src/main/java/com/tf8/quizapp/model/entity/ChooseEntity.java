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
	 * Getter of the ID
	 * @return ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter of the ID
	 * @param id ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter of the date
	 * @return date
	 */
	public Timestamp getDate() {
		return date;
	}

	/**
	 * Setter of the date
	 * @param date Timestamp date
	 */
	public void setDate(Timestamp date) {
		this.date = date;
	}

	/**
	 * Getter of the user object
	 * @return USER
	 */
	public UserEntity getUser() {
		return user;
	}

	/**
	 * Setter of the USER object
	 * @param user UserEntity object
	 */
	public void setUser(UserEntity user) {
		this.user = user;
	}

	/**
	 * Getter of the Option object
	 * @return Option
	 */
	public OptionsEntity getOption() {
		return option;
	}

	/**
	 * Setter of the Option object
	 * @param option OptionEntity object
	 */
	public void setOption(OptionsEntity option) {
		this.option = option;
	}

	/**
	 * Getter of the QuizEntity object
	 * @return QuizEntity object
	 */
	public QuizEntity getQuiz() {
		return quiz;
	}

	/**
	 * Setter of the Quiz object
	 * @param quiz QuizEntity object
	 */
	public void setQuiz(QuizEntity quiz) {
		this.quiz = quiz;
	}
}