package fr.esigelec.projetFullStackAPI.dto;

/**
* @author imane
*/

public class QuestionDTO {

	private Long id;
	private String question;

	/**
	 * Constructor without parameters
	 */
	public QuestionDTO() {
	}

	/**
	 * Getter of the question
	 * 
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Setter of the question
	 * 
	 * @param question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * Getter of the question's ID
	 * 
	 * @return the question's ID
	 */
	public Long getId() {
		return id;
	}
}