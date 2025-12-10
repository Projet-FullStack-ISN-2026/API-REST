package com.tf8.quizapp.model.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
* @author imane
*/

@Entity
@Table(name = "quiz")
public class QuizEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	/**
	 * The status of the quiz
	 * 10 for the status : 'NOT STARTED'
	 * 20 for the status 'RUNNING'
	 * 30 for the status 'FINISHED'
	 */
	@Column(nullable = false)
	private int status;
	@Column(nullable = false)
	private Timestamp startQuestionTime;
	@Column(nullable = false)
	private int currentQuestionNumber;
	@Column(nullable = false)
	/**
	 * this attribute refers to what is displayed 
	 * 10 to display a question
	 * 20 to display the percentage
	 * 30 to display the answer
	 * 40 to display the ranking of the players
	 */
	private int step;
	
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
}
