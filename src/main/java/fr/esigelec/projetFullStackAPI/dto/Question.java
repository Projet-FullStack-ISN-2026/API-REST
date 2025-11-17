/**
 * @author imane
 */

package fr.esigelec.projetFullStackAPI.dto;

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
