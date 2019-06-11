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

import com.FAS.entities.Sale;
import com.FAS.service.ISaleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/Sales")
@Api(value="REST Sale")
public class SaleController {
	@Autowired
	private ISaleService SaleService;
	
	@ApiOperation("Registro de Sales")
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveSale(@Valid @RequestBody Sale Sale)
	{
		try {
			Sale hor = new Sale();
			hor= SaleService.save(Sale);
			
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(hor.getId()).toUri();
			
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
					
		}
	}
	
	@ApiOperation("Listado de Sales")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sale>> fetchSales(){
		try {
			List<Sale> Sales = new ArrayList<>();
			Sales= SaleService.findAll();
			return new ResponseEntity<List<Sale>>(Sales,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Sale>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Obtener Sale por id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sale> fetchSale(@PathVariable("id") Integer id) {

		try {
			Optional<Sale> bO = SaleService.findById(id);

			if (!bO.isPresent()) {
				return new ResponseEntity<Sale>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Sale>(bO.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Sale>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Actualizar Sale")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@Valid @RequestBody Sale Sale) {
		try {
			SaleService.update(Sale);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation("Eliminar Sale por id")
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			Optional<Sale> hor = SaleService.findById(id);

			if (!hor.isPresent()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				SaleService.deleteById(id);
				return new ResponseEntity<>("Sale se elimino", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	

}
