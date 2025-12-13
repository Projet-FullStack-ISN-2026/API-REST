/**

* @author imane

*/

package com.tf8.quizapp.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "question")
public class QuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String question;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<OptionsEntity> options;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OptionsEntity> getOptions() {
		return options;
	}

	public void setOptions(List<OptionsEntity> options) {
		this.options = options;
	}
	
	

}
