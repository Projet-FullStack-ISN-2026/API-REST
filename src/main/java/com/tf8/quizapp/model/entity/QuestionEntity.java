/**

* @author imane

*/
 
package com.tf8.quizapp.model.entity;
 
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
 
@Entity

public class QuestionEntity {
 
	@Id

	private Long id;

	private String question;

	public String getQuestion() {

		return question;

	}

	public void setQuestion(String question) {

		this.question = question;

	}

}

 