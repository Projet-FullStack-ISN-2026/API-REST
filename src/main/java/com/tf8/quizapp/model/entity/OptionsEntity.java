package com.tf8.quizapp.model.entity;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
* @author imane
*/ 
@Entity
@Table(name = "options")
public class OptionsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String text;

	//A rajouter dans la DTO
	@Column( nullable = false)
    private boolean isCorrect;
	
	//A rajouter dans la DTO
	@ManyToOne
    @JoinColumn(name = "question_id") 
    private QuestionEntity question;
	
	
	public Long getId() {
		return id;
	}
	/**
	 * Getter of the Option's content
	 * @return the Option's content
	 */
	public String getText() {
		return text;
	}
	/**
	 * Setter of the Option's content
	 * @param text the Option's content
	 */
	public void setText(String text) {
		this.text = text;
	}
	public boolean getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public QuestionEntity getQuestion() {
		return question;
	}
	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}
	
	
}
 