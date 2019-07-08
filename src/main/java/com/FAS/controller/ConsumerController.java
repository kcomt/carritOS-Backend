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

import com.FAS.entities.Consumer;
import com.FAS.service.IConsumerService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/consumers")
@Api(value="REST consumer")
public class ConsumerController {

	@Autowired
	private IConsumerService consumerService;
	
	@ApiOperation("Registro de consumers")
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveconsumer(@Valid @RequestBody Consumer consumer)
	{
		try {
			Consumer hor = new Consumer();
			hor= consumerService.save(consumer);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hor.getId()).toUri();
			
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
	}
	
	@ApiOperation("Listado de consumers")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Consumer>> fetchconsumers(){
		try {
			List<Consumer> consumers = new ArrayList<>();
			consumers= consumerService.findAll();
			return new ResponseEntity<List<Consumer>>(consumers,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Consumer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener consumer por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Consumer> fetchconsumer(@PathVariable("id") Integer id) {

		try {
			Optional<Consumer> bO = consumerService.findById(id);

			if (!bO.isPresent()) {
				return new ResponseEntity<Consumer>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Consumer>(bO.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Consumer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener consumer por username")
	@GetMapping(value = "/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Consumer> fetchconsumerByUsername(@PathVariable("username") String username) {
		try {
			Consumer bO = new Consumer();
			bO = consumerService.findByUsername(username);
			return new ResponseEntity<Consumer>(bO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Consumer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Actualizar consumer")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Consumer consumer) {
		try {
			consumerService.update(consumer);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Eliminar consumer por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Consumer> hor = consumerService.findById(id);

			if (!hor.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				consumerService.deleteById(id);
				return new ResponseEntity<>("consumer se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
