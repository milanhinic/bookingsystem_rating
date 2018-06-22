package com.xml.rating.entity;

public class RatingAvgGrade {

	private Long Accommodation;
	private Double AvgGrade;
	
	public RatingAvgGrade(Long accommodation, Double avgGrade) {
		super();
		Accommodation = accommodation;
		AvgGrade = avgGrade;
	}

	public Long getAccommodation() {
		return Accommodation;
	}

	public void setAccommodation(Long accommodation) {
		Accommodation = accommodation;
	}

	public Double getAvgGrade() {
		return AvgGrade;
	}

	public void setAvgGrade(Double avgGrade) {
		AvgGrade = avgGrade;
	}
	
	
	
}
