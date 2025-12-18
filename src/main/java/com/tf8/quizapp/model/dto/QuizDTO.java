 package com.tf8.quizapp.model.dto;
 
import java.sql.Timestamp;

import jakarta.validation.constraints.NotNull;
 
/**
* @author imane
*/
public class QuizDTO {
	@NotNull(message = "Quiz ID is required")
	private Long id;
	private String title;
	/**
	 * The status of the quiz
	 * 10 for the status : 'NOT STARTED'
	 * 20 for the status 'RUNNING'
	 * 30 for the status 'FINISHED'
	 */
	private Integer status;
	private Timestamp startQuestionTime;
	private Integer currentQuestionNumber;
	
	/**
	 * this attribute fait référence à quoi est affiché
	 * 10 to display a question
	 * 20 to display the percentage
	 * 30 to display the answer
	 * 40 to display classement of the players
	 */
	private Integer step;

    /**
     * Gets the quiz ID.
     * @return the quiz's ID
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	/**
	 * Gets the title.
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 * @param title the new title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the current status.
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 * @param status the new status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	/**
	 * Gets the timestamp when the question started.
	 * @return the start question time
	 */
	public Timestamp getStartQuestionTime() {
		return startQuestionTime;
	}
	
	/**
	 * Sets the timestamp for when the question started.
	 * @param startQuestionTime the start question time to set
	 */
	public void setStartQuestionTime(Timestamp startQuestionTime) {
		this.startQuestionTime = startQuestionTime;
	}
	
	
	/**
	 * Gets the number of the current question.
	 * @return the current question number
	 */
	public Integer getCurrentQuestionNumber() {
		return currentQuestionNumber;
	}
	
	/**
	 * Sets the number of the current question.
	 * @param currentQuestionNumber the current question number to set
	 */
	public void setCurrentQuestionNumber(Integer currentQuestionNumber) {
		this.currentQuestionNumber = currentQuestionNumber;
	}
	
	/**
	 * Gets the current step.
	 * @return the step
	 */
	public Integer getStep() {
		return step;
	}
	
	/**
	 * Sets the current step.
	 * @param step the new step to set
	 */
	public void setStep(Integer step) {
		this.step = step;
	}

	
}
 
 