/**

* @author imane

*/

package com.tf8.quizapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class QuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String question;

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

}
