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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.FAS.entities.BuisnessOwner;
import com.FAS.entities.Consumer;
import com.FAS.service.IBuisnessOwnerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/buisnessOwners")
@Api(value="REST buisnessOwner")
public class BuisnessOwnerController {

	@Autowired
	private IBuisnessOwnerService buisnessOwnerService;
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@ApiOperation("Registro de buisnessOwners")
	@PostMapping(value = "/safe", consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> savebuisnessOwner(@Valid @RequestBody BuisnessOwner buisnessOwner)
	{
		try {
			BuisnessOwner hor = new BuisnessOwner();
			buisnessOwner.setPassword(passwordEncoder.encode(buisnessOwner.getPassword()));
			hor= buisnessOwnerService.save(buisnessOwner);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hor.getId()).toUri();
			
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
	}
	
	@ApiOperation("Listado de buisnessOwners")
	@GetMapping(value = "/safe", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BuisnessOwner>> fetchbuisnessOwners(){
		try {
			List<BuisnessOwner> buisnessOwners = new ArrayList<>();
			buisnessOwners= buisnessOwnerService.findAll();
			return new ResponseEntity<List<BuisnessOwner>>(buisnessOwners,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<BuisnessOwner>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener buisnessOwner por id")
	@GetMapping(value = "/safe/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BuisnessOwner> fetchbuisnessOwner(@PathVariable("id") Integer id) {

		try {
			Optional<BuisnessOwner> bO = buisnessOwnerService.findById(id);

			if (!bO.isPresent()) {
				return new ResponseEntity<BuisnessOwner>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<BuisnessOwner>(bO.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<BuisnessOwner>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener buisnessOwner por username")
	@GetMapping(value = "/safe/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BuisnessOwner> fetchbuisnessOwnerByUsername(@PathVariable("username") String username) {

		try {
			BuisnessOwner bO = buisnessOwnerService.findByUsername(username);
			return new ResponseEntity<BuisnessOwner>(bO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<BuisnessOwner>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Actualizar buisnessOwner")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody BuisnessOwner buisnessOwner) {
		try {
			buisnessOwnerService.update(buisnessOwner);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Eliminar buisnessOwner por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<BuisnessOwner> hor = buisnessOwnerService.findById(id);

			if (!hor.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				buisnessOwnerService.deleteById(id);
				return new ResponseEntity<>("buisnessOwner se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
