package com.tf8.quizapp.model.entity;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	
	@Column(nullable = false)
    private Boolean isCorrect;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "question")
	private QuestionEntity question;
	/**
	 * Getter of the option's ID
	 * @return ID the option's ID
	 */
	public Long getId() {
	    return this.id;
	}
	/**
	 * Setter of the options' ID
	 * @param ID the option's ID
	 */
	public void setId(Long id)
	{
	  this.id=id;
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
	 * @param text  the Option's content
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * Getter of isCorrect
	 * @return true or false
	 */
	public Boolean isCorrect() {
        return this.isCorrect;
    }
	/**
	 * Setter of isCorrect
	 * @param isCorrect option's status
	 */
    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
    /**
     * Getter of the question
     * @return the question
     */
    public QuestionEntity getQuestion() {
        return question;
    }
    /**
     * Setter of the question
     * @param question the question
     */
    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }
    
   
}
 
 