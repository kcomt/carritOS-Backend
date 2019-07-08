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

import com.FAS.entities.BuisnessOwner;
import com.FAS.entities.Seller;
import com.FAS.service.ISellerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sellers")
@Api(value="REST Seller")
public class SellerController {

	@Autowired
	private ISellerService SellerService;
	
	@ApiOperation("Registro de Sellers")
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveSeller(@Valid @RequestBody Seller Seller)
	{
		try {
			Seller hor = new Seller();
			hor= SellerService.save(Seller);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hor.getId()).toUri();
			
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
	}
	
	@ApiOperation("Listado de Sellers")
	@GetMapping(value = "/safe", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Seller>> fetchSellers(){
		try {
			List<Seller> Sellers = new ArrayList<>();
			Sellers= SellerService.findAll();
			return new ResponseEntity<List<Seller>>(Sellers,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Seller>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@ApiOperation("Listado de Sellers")
	@GetMapping(value = "/safe/buisnessOwner/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Seller>> fetchSellersByBuisnessOwnerId(@PathVariable("id") Integer id){
		try {
			List<Seller> Sellers = new ArrayList<>();
			Sellers= SellerService.fetchByBuisnessOwnerId(id);
			return new ResponseEntity<List<Seller>>(Sellers,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Seller>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener Seller por id")
	@GetMapping(value = "/safe/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Seller> fetchSeller(@PathVariable("id") Integer id) {

		try {
			Optional<Seller> bO = SellerService.findById(id);

			if (!bO.isPresent()) {
				return new ResponseEntity<Seller>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Seller>(bO.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Seller>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Obtener seller por username")
	@GetMapping(value = "/safe/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Seller> fetchbuisnessSellerByUsername(@PathVariable("username") String username) {

		try {
			Seller bO = SellerService.findByUsername(username);
			return new ResponseEntity<Seller>(bO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Seller>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Actualizar Seller")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Seller Seller) {
		try {
			SellerService.update(Seller);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Eliminar Seller por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Seller> hor = SellerService.findById(id);

			if (!hor.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				SellerService.deleteById(id);
				return new ResponseEntity<>("Seller se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
