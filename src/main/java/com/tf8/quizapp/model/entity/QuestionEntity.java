
/**

* @author imane

*/

package com.tf8.quizapp.model.entity;

import java.util.HashSet;
import java.util.Set;

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

@Entity
@Table(name = "question")
public class QuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String question;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<OptionsEntity> options;
	
	//ajouté par Ruben
	@ManyToMany(mappedBy = "questionsList")
	private Set<QuizEntity> quizList = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

	public Set<OptionsEntity> getOptions() {
		return options;
	}

	public void setOptions(Set<OptionsEntity> options) {
		this.options = options;
	}

    public Set<QuizEntity> getQuizList() {
        return quizList;
    }

    public void setQuizList(Set<QuizEntity> quizList) {
        this.quizList = quizList;
    }
}
