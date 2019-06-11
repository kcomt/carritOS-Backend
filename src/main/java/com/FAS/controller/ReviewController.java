package com.FAS.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.FAS.entities.Review;

import com.FAS.service.IReviewService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reviews")
@Api(value="REST review")
public class ReviewController {

	@Autowired
	private IReviewService reviewService;
	
	@ApiOperation("Registro de reviews")
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> savereview(@Valid @RequestBody Review review)
	{
		try {
			Review hor = new Review();
			hor= reviewService.save(review);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hor.getId()).toUri();
			
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
	}
	
	@ApiOperation("Listado de reviews")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Review>> fetchreviews(){
		try {
			List<Review> reviews = new ArrayList<>();
			reviews= reviewService.findAll();
			return new ResponseEntity<List<Review>>(reviews,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Review>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Listado de reviews")
	@GetMapping(value = "/foodtruck/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Review>> fetchreviewsByFoodTruckId(@PathVariable("id") Integer id){
		try {
			List<Review> reviews = new ArrayList<>();
			reviews= reviewService.fetchByFoodTruckId(id);
			return new ResponseEntity<List<Review>>(reviews,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Review>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener review por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Review> fetchreview(@PathVariable("id") Integer id) {

		try {
			Optional<Review> bO = reviewService.findById(id);

			if (!bO.isPresent()) {
				return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Review>(bO.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Review>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Actualizar review")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Review review) {
		try {
			reviewService.update(review);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Eliminar review por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Review> hor = reviewService.findById(id);

			if (!hor.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				reviewService.deleteById(id);
				return new ResponseEntity<>("review se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	

}
