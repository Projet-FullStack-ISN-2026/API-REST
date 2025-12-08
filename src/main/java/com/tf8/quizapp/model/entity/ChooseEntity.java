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

	// Lien vers Utilisateur
	@ManyToOne
	@JoinColumn(name = "utilisateur_id", nullable = false)
	private UserEntity utilisateur;

	// Lien vers Options
	@ManyToOne
	@JoinColumn(name = "options_id", nullable = false)
	private OptionsEntity option;

	// Lien vers Quiz
	@ManyToOne
	@JoinColumn(name = "quiz_id", nullable = false)
	private QuizEntity quiz;

	public ChooseEntity() {
	}

	// --- Getters et Setters ---

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public UserEntity getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UserEntity utilisateur) {
		this.utilisateur = utilisateur;
	}

	public OptionsEntity getOption() {
		return option;
	}

	public void setOption(OptionsEntity option) {
		this.option = option;
	}

	public QuizEntity getQuiz() {
		return quiz;
	}

	public void setQuiz(QuizEntity quiz) {
		this.quiz = quiz;
	}
}