package com.tf8.quizapp.model.dto;

/**
 * @author SEWANOU OZA Ruben
 */

public class DistributionDTO {
	private Long optionId;
    private Integer count;
    private double percentage;
    
    public DistributionDTO () {
	
    }
    
    public DistributionDTO (Long optionId, Integer count, double pourcentage) {
    	this.optionId = optionId;
    	this.count = count;
    	this.percentage = percentage;
    }
    
	public Long getOptionId() {
		return optionId;
	}
	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
    
    
}