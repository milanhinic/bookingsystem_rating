package com.xml.rating.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.xml.rating.entity.Rating;
import com.xml.rating.entity.RatingAvgGrade;
import com.xml.rating.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public List<Rating> findAll() {
		logger.info("> findAll");
		List<Rating> entities = ratingRepository.findAll();
		logger.info("< findAll");
		return entities;
	}

	@Override
	public Rating findById(Long id) {
		logger.info("> findById id:{}", id);
		Rating entity = ratingRepository.findById(id).get();
		logger.info("< findById id:{}", id);
		return entity;
	}

	@Override
	public Rating save(Rating rating) {
		logger.info("> create");
		Rating newEntity = ratingRepository.save(rating);
		logger.info("< create");
		return newEntity;
	}

	@Override
	public Rating update(Rating rating) {
		logger.info("> update");
		Rating changeRating = ratingRepository.findById(rating.getId()).get();
		changeRating.setAccommodation(rating.getAccommodation());
		changeRating.setContent(rating.getContent());
		changeRating.setGrade(rating.getGrade());
		changeRating.setKorisnik(rating.getKorisnik());
		changeRating.setRezervacija(rating.getRezervacija());
		Rating newEntity = ratingRepository.save(changeRating);
		logger.info("< update");
		return newEntity;
	}

	@Override
	public void delete(Long id) {
		logger.info("> delete");
		ratingRepository.deleteById(id);
		logger.info("< delete");
	}

	@Override
	public Long count() {
		logger.info("> count");
		Long count = ratingRepository.count();
		logger.info("< count");
		return count;
	}

	@Override
	public List<Rating> findAll(Integer page, Integer size) {
		logger.info("> findAll");
		Page<Rating> pages = ratingRepository.findAll(PageRequest.of(page, size));
		List<Rating> entities = pages.getContent();
		logger.info("< findAll");
		return entities;
	}

	@Override
	public List<Rating> findByAccommodation(Long id) {
		logger.info("> findByAccommodation id:{}", id);
		List<Rating> entity = ratingRepository.getByAccommodation(id);
		logger.info("< findByAccommodation id:{}", id);
		return entity;
	}

	@Override
	public List<Rating> findByKorisnik(Long id) {
		logger.info("> findByKorisnik id:{}", id);
		List<Rating> entity = ratingRepository.getByKorisnik(id);
		logger.info("< findByKorisnik id:{}", id);
		return entity;
	}

	@Override
	public List<Rating> findByReservation(Long id) {
		logger.info("> findByReservation id:{}", id);
		List<Rating> entity = ratingRepository.getByRezervacija(id);
		logger.info("< findByReservation id:{}", id);
		return entity;
	}

	@Override
	public List<Rating> findByAccommodationAndGrade(Long accommodation, Long grade) {
		logger.info("> findByAccommodationAndGrade ");
		List<Rating> entity = ratingRepository.findByAccommodationAndGrade(accommodation, grade);
		logger.info("< findByAccommodationAndGrade");
		return entity;
	}

	@Override
	public List<RatingAvgGrade> sortByAvgGrade() {
		logger.info("> sortByAvgGrade ");
		List<RatingAvgGrade> entity = ratingRepository.sortByAvgGrade();
		logger.info("< sortByAvgGrade");
		return entity;
	}

}
