/**
 * @author imane
 */

package fr.esigelec.projectFullStackAPI.dto;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="options")

public class Quiz {

	@Id
	private Long id;
	private String title;
	/**
	 * The status of the quiz
	 * 10 for the status : 'NOT STARTED'
	 * 20 for the status 'RUNNING'
	 * 30 for the status 'FINISHED'
	 */
	private int status;
	private Timestamp startQuestionTime;
	private int currentQuestionNumber;
	
	/**
	 * this attribute fait référence à quoi est affiché 
	 * 10 to display a question
	 * 20 to display the percentage 
	 * 30 to display the answer
	 * 40 to display classement of the players 
	 */
	private int step;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getStartQuestionTime() {
		return startQuestionTime;
	}

	public void setStartQuestionTime(Timestamp startQuestionTime) {
		this.startQuestionTime = startQuestionTime;
	}

	public int getCurrentQuestionNumber() {
		return currentQuestionNumber;
	}

	public void setCurrentQuestionNumber(int currentQuestionNumber) {
		this.currentQuestionNumber = currentQuestionNumber;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
}
