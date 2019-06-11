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

import com.FAS.entities.FoodTruck;

import com.FAS.service.IFoodTruckService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/foodTrucks")
@Api(value="REST foodTruck")
public class FoodTruckController {

	@Autowired
	private IFoodTruckService foodTruckService;
	
	@ApiOperation("Registro de foodTrucks")
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> savefoodTruck(@Valid @RequestBody FoodTruck foodTruck)
	{
		try {
			FoodTruck hor = new FoodTruck();
			hor= foodTruckService.save(foodTruck);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hor.getId()).toUri();
			
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
	}
	
	@ApiOperation("Listado de foodTrucks")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FoodTruck>> fetchfoodTrucks(){
		try {
			List<FoodTruck> foodTrucks = new ArrayList<>();
			foodTrucks= foodTruckService.findAll();
			return new ResponseEntity<List<FoodTruck>>(foodTrucks,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<FoodTruck>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Listado de foodTrucks")
	@GetMapping(value = "/ordered", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FoodTruck>> fetchfoodTrucksOrdered(){
		try {
			List<FoodTruck> foodTrucks = new ArrayList<>();
			foodTrucks= foodTruckService.fetchAllFoodTruckOrderByRating();
			return new ResponseEntity<List<FoodTruck>>(foodTrucks,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<FoodTruck>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener foodTruck por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FoodTruck> fetchfoodTruck(@PathVariable("id") Integer id) {

		try {
			Optional<FoodTruck> bO = foodTruckService.findById(id);

			if (!bO.isPresent()) {
				return new ResponseEntity<FoodTruck>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<FoodTruck>(bO.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<FoodTruck>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener foodTruck por nombre")
	@GetMapping(value = "/search/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FoodTruck>> fetchfoodTruckbyName(@PathVariable("name") String name) {

		try {
			List<FoodTruck> bO = new ArrayList<>();
			bO = foodTruckService.fetchByName(name);
			return new ResponseEntity<List<FoodTruck>>(bO,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<FoodTruck>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener foodTruck por nombre")
	@GetMapping(value = "/owner/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FoodTruck>> fetchfoodTruckbyName(@PathVariable("ownerId") Integer ownerId) {

		try {
			List<FoodTruck> bO = new ArrayList<>();
			bO = foodTruckService.fetchByBuisnessOwnerId(ownerId);
			return new ResponseEntity<List<FoodTruck>>(bO,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<FoodTruck>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Actualizar foodTruck")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody FoodTruck foodTruck) {
		try {
			foodTruckService.update(foodTruck);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Eliminar foodTruck por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<FoodTruck> hor = foodTruckService.findById(id);

			if (!hor.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				foodTruckService.deleteById(id);
				return new ResponseEntity<>("foodTruck se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
