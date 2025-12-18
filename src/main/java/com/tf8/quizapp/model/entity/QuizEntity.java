package com.tf8.quizapp.model.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
* @author imane
*/

@Entity
@Table(name = "quiz")
public class QuizEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank(message = "Quiz's ID is required")
	private Long id;
	
	@Column(nullable = false)
	@NotBlank(message = "Quiz's title is required")
	private String title;
	/**
	 * The status of the quiz
	 * 10 for the status : 'NOT STARTED'
	 * 20 for the status 'RUNNING'
	 * 30 for the status 'FINISHED'
	 */
	@Column(nullable = false)
	@NotBlank(message = "Quiz's status is  required")
	private int status;
	
	@Column(nullable = false)
	@NotBlank(message = "Quiz's starting time is required")
	private Timestamp startQuestionTime;
	
	@Column(nullable = false)
	@NotNull(message = "Quiz's current question number is required")
	private int currentQuestionNumber;
	
	@Column(nullable = false)
	@NotNull(message = "Quiz'step is required")
	/**
	 * this attribute refers to what is displayed 
	 * 10 to display a question
	 * 20 to display the percentage
	 * 30 to display the answer
	 * 40 to display the ranking of the players
	 */
	private int step;
	
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
	private List<QuestionEntity> questions = new ArrayList<>();	
	/**
	 * Gets the quiz ID.
	 * @return the quiz's ID
	 */
	public void setId(Long id) {
		this.id=id;
	}
	/**
	 * Setter of the quiz's ID
	 * @param id the quiz's ID
	 */
	public Long getId() {
		return this.id;
	}


	/**
	 * Getter of the quiz's title
	 * @return the quiz's title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Setter of the quiz's title 
	 * @param title the quiz's title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * Getter of the quiz's status
	 * @return the quiz's status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * Setter of the quiz's status
	 * @param status  the quiz's status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * Getter of startQuestionTime
	 * @return the starting time of the question
	 */
	public Timestamp getStartQuestionTime() {
		return startQuestionTime;
	}
	/**
	 * Setter of startQuestionTime
	 * @param startQuestionTime the starting time of the question
	 */
	public void setStartQuestionTime(Timestamp startQuestionTime) {
		this.startQuestionTime = startQuestionTime;
	}
	/**
	 * Getter of the number of the current question 
	 * @return  the number of the current question 
	 */
	public int getCurrentQuestionNumber() {
		return currentQuestionNumber;
	}	
	/**
	 * Setter of the number of the current question 
	 * @param currentQuestionNumber number of the current question 
	 */
	public void setCurrentQuestionNumber(int currentQuestionNumber) {
		this.currentQuestionNumber = currentQuestionNumber;
	}
	/**
	 * Getter of the question's step 
	 * @return the question's step 
	 */
	public int getStep() {
		return step;
	}
	/**
	 * Setter of the question's step 
	 * @param step
	 */
	public void setStep(int step) {
		this.step = step;
	}
	
	/**
	 * Getter of the quiz's questions
	 * @return the quiz's questions
	 */
	public List<QuestionEntity> getQuestions() {
		return questions;
	}
	/**
	 * Setter of the quiz's questions
	 * @param questions the quiz's questions
	 */
	public void setQuestions(List<QuestionEntity> questions) {
		 this.questions = questions;
	}
}
