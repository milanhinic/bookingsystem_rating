package com.xml.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xml.rating.entity.Rating;
import com.xml.rating.entity.RatingAvgGrade;

public interface RatingRepository extends JpaRepository<Rating, Long> {

	@Query("select r from Rating r where r.id = :id")
	Rating getById(@Param("id") Long id);

	@Query("select r from Rating r where r.korisnik = :korisnik")
	List<Rating> getByKorisnik(@Param("korisnik") Long id);

	@Query("select r from Rating r where r.rezervacija = :rezervacija")
	List<Rating> getByRezervacija(@Param("rezervacija") Long id);

	@Query("select r from Rating r where r.accommodation = :accommodation")
	List<Rating> getByAccommodation(@Param("accommodation") Long id);

	@Query("SELECT r FROM Rating r where r.accommodation = :accommodation AND r.grade = :grade")
	List<Rating> findByAccommodationAndGrade(@Param("accommodation") Long accommodation, @Param("grade") Long grade);

	@Query("select new com.xml.rating.entity.RatingAvgGrade(r.accommodation, avg(r.grade)) from Rating r group by r.accommodation order by avg(r.grade) desc ")
	List<RatingAvgGrade> sortByAvgGrade();

}
