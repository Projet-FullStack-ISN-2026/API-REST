 package com.tf8.quizapp.model.dto;
 
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
 
/**
* @author imane
*/
public class QuizDTO {
	@NotNull(message = "Quiz ID is required")
	private Long id;
	@NotNull(message = "Quiz title is required")
	private String title;
	
	/**
	 * The status of the quiz
	 * 10 for the status : 'NOT STARTED'
	 * 20 for the status 'RUNNING'
	 * 30 for the status 'FINISHED'
	 */
	@NotNull(message = "Quiz status is required")
	private int status;
	@NotNull(message = "Quiz statring time is required")
	private Timestamp startQuestionTime;
	@NotNull(message = "Quiz's current question number is required")
	private int currentQuestionNumber;
	/**
	 * this attribute fait référence à quoi est affiché
	 * 10 to display a question
	 * 20 to display the percentage
	 * 30 to display the answer
	 * 40 to display classement of the players
	 */
	@NotNull(message = "Quiz'step is required")
	private int step;
	@NotNull(message = "Quiz'step is required")
	@NotEmpty(message = "Question's list mustn't be empty")
	private List<QuestionDTO> listQuestions= new ArrayList<>();
	
	public List<QuestionDTO> getListQuestions() {
		return listQuestions;
	}
	/**
	 * Constructor
	 */
	public QuizDTO() {
	}
	/**
	 * Gets the quiz ID.
	 * @return the quiz's ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Setter of the quiz's ID
	 * @param id the quiz's ID
	 */
	public void setId(Long id) {
		this.id=id;
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
	public int getStatus() {
		return status;
	}
	/**
	 * Sets the status.
	 * @param status the new status to set
	 */
	public void setStatus(int status) {
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
	public int getCurrentQuestionNumber() {
		return currentQuestionNumber;
	}
	/**
	 * Sets the number of the current question.
	 * @param currentQuestionNumber the current question number to set
	 */
	public void setCurrentQuestionNumber(int currentQuestionNumber) {
		this.currentQuestionNumber = currentQuestionNumber;
	}
	/**
	 * Gets the current step.
	 * @return the step
	 */
	public int getStep() {
		return step;
	}
	/**
	 * Sets the current step.
	 * @param step the new step to set
	 */
	public void setStep(int step) {
		this.step = step;
	}
	/**
	 * Getter of the quiz's questions list
	 * @return the quiz's questions list
	 */
	public ArrayList<QuestionDTO> getQuestionList() {
	    return (ArrayList<QuestionDTO>) this.listQuestions;
	}
	/**
	 * Setter of the quiz's questions list
	 * @param questionList the new quiz's questions list
	 */
	public void setQuestionList(List<QuestionDTO> questionList) {
	    if (questionList != null) {
	        this.listQuestions = questionList;
	    } else if (questionList == null || questionList.isEmpty()) {
	        throw new IllegalArgumentException(
	                "The list of question mustn't be empty or null"
	            );
	}
	}

}
 
 