/**
 * @author imane
 */

package fr.esigelec.projectFullStackAPI.dto;

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
