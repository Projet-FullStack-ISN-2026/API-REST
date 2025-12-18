package com.tf8.quizapp.model.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tf8.quizapp.model.dto.QuestionDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	
	@Column(nullable = true)
	private String title;

	/**
	 * The status of the quiz
	 * 10 for the status : 'NOT STARTED'
	 * 20 for the status 'RUNNING'
	 * 30 for the status 'FINISHED'
	 */
	
	/*
	 * modifié par Ruben
	 * type int en type integer pour accepter les valeurs NULL
	 */
	@Column(nullable = true)
	private Integer status;



	@Column(nullable = true)
	private Timestamp startQuestionTime;

	/*
	 * modifié par Ruben
	 * type int en type integer pour accepter les valeurs NULL
	 */
	@Column(nullable = true)
	private Integer currentQuestionNumber;

    /**
     * this attribute refers to what is displayed
     * 10 to display a question
     * 20 to display the percentage
     * 30 to display the answer
     * 40 to display the ranking of the players
     */
	@Column(nullable = true)
	private Integer step;
	
	//ajouté pour test
	@ManyToMany()
    @JoinTable(
        name = "quiz_question", // Nom de la table de jointure
        joinColumns = @JoinColumn(name = "quiz_id"), // Colonne de cette entité (Quiz) dans la table de jointure
        inverseJoinColumns = @JoinColumn(name = "question_id") // Colonne de l'autre entité (Question)
    )
	private List<QuestionEntity> questionsList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
	public List<QuestionEntity> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<QuestionEntity> questionsList) {
		this.questionsList = questionsList;
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
	public Integer getStatus() {
		return status;
	}

	/**
	 * Setter of the quiz's status
	 * @param status the quiz's status
	 */
	public void setStatus(Integer status) {
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
	public Integer getCurrentQuestionNumber() {
		return currentQuestionNumber;
	}

	/**
	 * Setter of the number of the current question 
	 * @param currentQuestionNumber number of the current question 
	 */
	public void setCurrentQuestionNumber(Integer currentQuestionNumber) {
		this.currentQuestionNumber = currentQuestionNumber;
	}

	/**
	 * Getter of the question's step 
	 * @return the question's step 
	 */
	public Integer getStep() {
		return step;
	}

	/**
	 * Setter of the question's step 
	 * @param step question's step
	 */
	public void setStep(Integer step) {
		this.step = step;
	}
}