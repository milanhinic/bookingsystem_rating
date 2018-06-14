package com.xml.rating.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "korisnik")
	private Long korisnik;
	
	@Column(name = "rezervacija")
	private Long rezervacija;
	
	@Column(name = "accommodation")
	private Long accommodation;
	
	@Column(name = "grade")
	private Long grade;
	
	@Column(name = "content")
	private String content;

	public Rating() {
		super();
	}

	public Rating(Long id, Long korisnik, Long rezervacija, Long accommodation, Long grade, String content) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.rezervacija = rezervacija;
		this.accommodation = accommodation;
		this.grade = grade;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Long korisnik) {
		this.korisnik = korisnik;
	}

	public Long getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Long rezervacija) {
		this.rezervacija = rezervacija;
	}

	public Long getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(Long accommodation) {
		this.accommodation = accommodation;
	}

	public Long getGrade() {
		return grade;
	}

	public void setGrade(Long grade) {
		this.grade = grade;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", korisnik=" + korisnik + ", rezervacija=" + rezervacija + ", accommodation="
				+ accommodation + ", grade=" + grade + ", content=" + content + "]";
	}



}
