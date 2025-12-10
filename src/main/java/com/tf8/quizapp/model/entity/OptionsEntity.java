package com.tf8.quizapp.model.entity;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
* @author imane
*/ 
@Entity
public class OptionsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String text;
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
}
 
 