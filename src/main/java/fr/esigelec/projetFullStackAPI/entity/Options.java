/**
 * @author imane
 */

<<<<<<<< HEAD:src/main/java/fr/esigelec/projetFullStackAPI/dto/Options.java
package fr.esigelec.projetFullStackAPI.dto;
========
package fr.esigelec.projetFullStackAPI.entity;
>>>>>>>> d88d97862f4c86226ed7cd1a68cb59d2b62acb48:src/main/java/fr/esigelec/projetFullStackAPI/entity/Options.java

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Options {

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
