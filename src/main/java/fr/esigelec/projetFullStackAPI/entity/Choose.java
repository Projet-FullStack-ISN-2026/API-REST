package fr.esigelec.projetFullStackAPI.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

/**
 * @author DIENE Serigne Fallou
 */

@Entity
@Table(name = "choose")
public class Choose {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Timestamp date;

	// Lien vers Utilisateur
	@ManyToOne
	@JoinColumn(name = "utilisateur_id", nullable = false)
	private Utilisateur utilisateur;

	// Lien vers Options
	@ManyToOne
	@JoinColumn(name = "options_id", nullable = false)
	private Options option;

	// Lien vers Quiz
	@ManyToOne
	@JoinColumn(name = "quiz_id", nullable = false)
	private Quiz quiz;

	public Choose() {
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Options getOption() {
		return option;
	}

	public void setOption(Options option) {
		this.option = option;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
}