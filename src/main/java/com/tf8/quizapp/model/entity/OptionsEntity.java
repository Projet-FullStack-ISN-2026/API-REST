/**
* @author imane
*/
 
package com.tf8.quizapp.model.entity;
 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
 
@Entity
public class OptionsEntity {
 
	@Id
	private Long id;
	private String text;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
 
 