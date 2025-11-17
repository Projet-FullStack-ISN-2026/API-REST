/**
 * @author imane
 */

<<<<<<<< HEAD:src/main/java/fr/esigelec/projetFullStackAPI/dto/Question.java
package fr.esigelec.projetFullStackAPI.dto;
========
package fr.esigelec.projetFullStackAPI.entity;
>>>>>>>> d88d97862f4c86226ed7cd1a68cb59d2b62acb48:src/main/java/fr/esigelec/projetFullStackAPI/entity/Question.java

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Question {

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
