package com.xml.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xml.rating.entity.Rating;
import com.xml.rating.entity.RatingAvgGrade;
import com.xml.rating.service.RatingService;

@RestController
@RequestMapping(value = "/rating")
public class RatingController {

	@Autowired
	private RatingService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Rating> addNew(@RequestBody Rating entity) {

		Rating ret = service.save(entity);
		if (ret == null)
			return new ResponseEntity<Rating>(ret, HttpStatus.CONFLICT);
		else
			return new ResponseEntity<Rating>(ret, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getAll/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Rating>> getAll(@PathVariable(value = "id") Long id) {

		List<Rating> list = null;

		list = service.findByAccommodation(id);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Total-Count", String.valueOf(service.count()));
		if (list.isEmpty())
			return new ResponseEntity<List<Rating>>(list, headers, HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Rating>>(list, headers, HttpStatus.OK);

	}

	@RequestMapping(value = "/getAll/{id}/{grade}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Rating>> getAllGrade(@PathVariable(value = "id") Long id,
			@PathVariable(value = "grade") Long grade) {

		List<Rating> list = null;

		// System.err.println("Id : " + id +" , grade: " + grade);
		list = service.findByAccommodationAndGrade(id, grade);
		// System.err.println("Result : " + list);
		if (list.isEmpty())
			return new ResponseEntity<List<Rating>>(list, HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Rating>>(list, HttpStatus.OK);

	}

	@RequestMapping(value = "/getAll/{id}/avg", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAvg(@PathVariable(value = "id") Long id) {

		int i = 0;
		double sum = 0.0;
		double res = 0.0;
		String result = "";
		List<Rating> list = null;

		list = service.findByAccommodation(id);

		for (Rating r : list) {
			i++;
			sum += r.getGrade();
		}
		res = sum / i;
		result = String.valueOf(res);
		// System.err.println(result);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Total-Count", String.valueOf(service.count()));
		if (list.isEmpty())
			return new ResponseEntity<String>(result, headers, HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<String>(result, headers, HttpStatus.OK);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rating> getID(@PathVariable(value = "id") Long id) {
		Rating ret = service.findById(id);
		if (ret == null)
			return new ResponseEntity<Rating>(ret, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Rating>(ret, HttpStatus.OK);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<Rating> update(@RequestBody Rating entity) {
		Rating ret = service.update(entity);
		if (ret == null)
			return new ResponseEntity<Rating>(ret, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Rating>(ret, HttpStatus.OK);
	}

	@RequestMapping(value = "/sortByAvgGrade", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RatingAvgGrade>> getSortByAvgGrade() {
		
		List<RatingAvgGrade> ret = service.sortByAvgGrade();

		if (ret == null)
			return new ResponseEntity<List<RatingAvgGrade>>(ret, HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<RatingAvgGrade>>(ret, HttpStatus.OK);
	}

}
