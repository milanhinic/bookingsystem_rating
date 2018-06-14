package com.xml.rating.service;

import java.util.List;

import com.xml.rating.entity.Rating;

public interface RatingService {

	List<Rating> findAll();

	List<Rating> findByAccommodationAndGrade(Long accommodation, Long grade);
	
	Rating findById(Long id);
	
	List<Rating> findByAccommodation(Long id);
	
	List<Rating> findByKorisnik(Long id);
	
	List<Rating> findByReservation(Long id);

	Rating save(Rating rating);

	Rating update(Rating rating);

	void delete(Long id);

	Long count();

	List<Rating> findAll(Integer page, Integer size);
	
}
