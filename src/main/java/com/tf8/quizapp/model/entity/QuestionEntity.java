package com.tf8.quizapp.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
/**
 * @author imane
 */

@Entity
@Table(name = "question")
public class QuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String question;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private QuizEntity quiz;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OptionsEntity> listOptions = new ArrayList<>();
	
	/**
	 * Getter of the question's ID
	 * return the question's ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Setter of the question's ID
	 * @param ID the question's ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Getter of the question content
	 * @return the question content
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * Setter of the question content 
	 * @param question the question content
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * Getter of the quiz that belongs to the current question
	 * @return the quiz that belongs to the current question
	 */
	public QuizEntity getQuiz() {
		return quiz;
	}
	/**
	 * Setter of the quiz that belongs to the current question
	 * @param quiz the quiz that belongs to the current question
	 */
	public void setQuiz(QuizEntity quiz) {
		this.quiz = quiz;
	}
	/**
	 * Getter of the options list
	 * @return the options list
	 */
	public List<OptionsEntity> getListOptions() {
		return listOptions;
	}
	/**
	 * Setter of the options list
	 * @param options the options list
	 */
	public void setListOptions(List<OptionsEntity> options) {
		this.listOptions = options;
	}

	
}
