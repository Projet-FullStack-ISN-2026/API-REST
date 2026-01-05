
package com.tf8.quizapp.model.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SEWANOU OZA Ruben
 */
public class AdminStatDTO {
	private Long questionId;
	private Integer totalVotes;
	private List<DistributionDTO> listDistribution;
	
	public AdminStatDTO() {
		
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Integer getTotalVotes() {
		return totalVotes;
	}

	public void setTotalVotes(Integer totalVotes) {
		this.totalVotes = totalVotes;
	}

	public List<DistributionDTO> getListDistribution() {
		return listDistribution;
	}

	public void setListDistribution(List<DistributionDTO> listDistribution) {
		this.listDistribution = listDistribution;
	}


}
